#!/usr/bin/env bash


. "$(git --exec-path)/git-sh-setup"
require_clean_work_tree bump_version "The current work tree needs to be clean for the script to work."
CURRENT_BRANCH=`git rev-parse --abbrev-ref HEAD`
if [ $CURRENT_BRANCH != "release" ]
then
    echo "Current branch needs to be master for the script to work."
    exit 1
fi
git pull

VERSION_STR=`grep 'packageVersion = ' gradle.properties | tr -d 'packageVersion = '`
BUMPED_VERSION_STR=`echo $VERSION_STR | awk -F '.' '{print $1"."$2"."($3 + 1)}'`
RELEASE_TAG="v$VERSION_STR"


git tag -a $RELEASE_TAG -m "Releasing version $VERSION_STR"

sed -i -e "s/packageVersion = $VERSION_STR/packageVersion = $BUMPED_VERSION_STR/g" gradle.properties
rm gradle.properties-e

git add gradle.properties

git commit -m "Bumping version to $BUMPED_VERSION_STR"

git push origin $RELEASE_TAG
git push