package org.ocaml.ide.commenter

import com.intellij.lang.Commenter

/**
 * Created by sidharthkuruvila on 16/05/16.
 */

class OcamlCommenter : Commenter {
    override fun getCommentedBlockCommentPrefix(): String? = "(*"

    override fun getCommentedBlockCommentSuffix(): String? = "*)"

    override fun getBlockCommentPrefix(): String? = "(*"

    override fun getBlockCommentSuffix(): String? = "*)"

    override fun getLineCommentPrefix(): String? = null

}