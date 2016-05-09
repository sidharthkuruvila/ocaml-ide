import re

non_terminals = ['implementation',
                 'interface',
                 'toplevel_phrase',
                 'top_structure',
                 'top_structure_tail',
                 'use_file',
                 'use_file_body',
                 'use_file_tail',
                 'parse_core_type',
                 'parse_expression',
                 'parse_pattern',
                 'functor_arg',
                 'functor_arg_name',
                 'functor_args',
                 'module_expr',
                 'structure',
                 'structure_tail',
                 'structure_item',
                 'str_include_statement',
                 'module_binding_body',
                 'module_binding',
                 'rec_module_bindings',
                 'rec_module_binding',
                 'and_module_binding',
                 'module_type',
                 'signature',
                 'signature_item',
                 'open_statement',
                 'sig_include_statement',
                 'module_declaration_body',
                 'module_declaration',
                 'module_alias',
                 'rec_module_declarations',
                 'rec_module_declaration',
                 'and_module_declaration',
                 'module_type_declaration_body',
                 'module_type_declaration',
                 'class_declarations',
                 'class_declaration',
                 'and_class_declaration',
                 'class_fun_binding',
                 'class_type_parameters',
                 'class_fun_def',
                 'class_expr',
                 'class_simple_expr',
                 'class_structure',
                 'class_self_pattern',
                 'class_fields',
                 'class_field',
                 'parent_binder',
                 'value',
                 'method_',
                 'class_type',
                 'class_signature',
                 'class_sig_body',
                 'class_self_type',
                 'class_sig_fields',
                 'class_sig_field',
                 'value_type',
                 'constrain',
                 'constrain_field',
                 'class_descriptions',
                 'class_description',
                 'and_class_description',
                 'class_type_declarations',
                 'class_type_declaration',
                 'and_class_type_declaration',
                 'seq_expr',
                 'labeled_simple_pattern',
                 'pattern_var',
                 'opt_default',
                 'label_let_pattern',
                 'label_var',
                 'let_pattern',
                 'expr',
                 'simple_expr',
                 'simple_labeled_expr_list',
                 'labeled_simple_expr',
                 'label_expr',
                 'label_ident',
                 'lident_list',
                 'let_binding_body',
                 'let_bindings',
                 'let_binding',
                 'and_let_binding',
                 'fun_binding',
                 'strict_binding',
                 'match_cases',
                 'match_case',
                 'fun_def',
                 'expr_comma_list',
                 'record_expr',
                 'lbl_expr_list',
                 'lbl_expr',
                 'field_expr_list',
                 'field_expr',
                 'expr_semi_list',
                 'type_constraint',
                 'opt_type_constraint',
                 'pattern',
                 'pattern_no_exn',
                 'pattern_gen',
                 'simple_pattern',
                 'simple_pattern_not_ident',
                 'pattern_comma_list',
                 'pattern_no_exn_comma_list',
                 'pattern_semi_list',
                 'lbl_pattern_list',
                 'lbl_pattern',
                 'opt_pattern_type_constraint',
                 'value_description',
                 'primitive_declaration_body',
                 'primitive_declaration',
                 'type_declarations',
                 'type_declaration',
                 'and_type_declaration',
                 'constraints',
                 'type_kind',
                 'optional_type_parameters',
                 'optional_type_parameter',
                 'optional_type_parameter_list',
                 'optional_type_variable',
                 'type_parameters',
                 'type_parameter',
                 'type_variance',
                 'type_variable',
                 'type_parameter_list',
                 'constructor_declarations',
                 'constructor_declaration',
                 'bar_constructor_declaration',
                 'str_exception_declaration',
                 'sig_exception_declaration',
                 'generalized_constructor_arguments',
                 'constructor_arguments',
                 'label_declarations',
                 'label_declaration',
                 'label_declaration_semi',
                 'str_type_extension',
                 'sig_type_extension',
                 'str_extension_constructors',
                 'sig_extension_constructors',
                 'extension_constructor_declaration',
                 'bar_extension_constructor_declaration',
                 'extension_constructor_rebind',
                 'bar_extension_constructor_rebind',
                 'with_constraints',
                 'with_constraint',
                 'with_type_binder',
                 'typevar_list',
                 'poly_type',
                 'poly_type_no_attr',
                 'core_type',
                 'core_type_no_attr',
                 'core_type2',
                 'simple_core_type',
                 'simple_core_type2',
                 'package_type',
                 'row_field_list',
                 'row_field',
                 'tag_field',
                 'opt_ampersand',
                 'amper_type_list',
                 'name_tag_list',
                 'simple_core_type_or_tuple',
                 'core_type_comma_list',
                 'core_type_list',
                 'meth_list',
                 'field',
                 'field_semi',
                 'label',
                 'constant',
                 'signed_constant',
                 'ident',
                 'val_ident',
                 'operator',
                 'constr_ident',
                 'val_longident',
                 'constr_longident',
                 'label_longident',
                 'type_longident',
                 'mod_longident',
                 'mod_ext_longident',
                 'mty_longident',
                 'clty_longident',
                 'class_longident',
                 'toplevel_directive',
                 'name_tag',
                 'rec_flag',
                 'nonrec_flag',
                 'direction_flag',
                 'private_flag',
                 'mutable_flag',
                 'virtual_flag',
                 'private_virtual_flags',
                 'override_flag',
                 'opt_bar',
                 'opt_semi',
                 'subtractive',
                 'additive',
                 'single_attr_id',
                 'attr_id',
                 'attribute',
                 'post_item_attribute',
                 'floating_attribute',
                 'post_item_attributes',
                 'attributes',
                 'ext_attributes',
                 'extension',
                 'item_extension',
                 'payload']

package = "org.ocaml.lang.parser.psi"

path = "../src/main/kotlin"

import os


def makedirs(path):
    try:
        os.makedirs(path)
    except OSError:
        pass


class GenParser(object):
    def __init__(self, path, package, prefix, non_terminals_super):
        self.path = path
        self.package = package
        self.prefix = prefix
        self.gen_path = path + "/" + package.replace(".", "/") + ""
        self.non_terminals_super = non_terminals_super

    def non_terminals(self):
        print self.gen_path
        makedirs(self.gen_path)
        f = file(self.gen_path + "/%sNonTerminals.kt" % self.prefix, "w")

        f.write("package %s\n" % self.package)
        f.write("import org.ocaml.lang.parser.OcamlNonTerminalElementType\n")

        f.write("object %sNonTerminals {\n" % (self.prefix))

        for non_terminal in non_terminals:
            f.write('val %s = %s("%s")\n' % (non_terminal.upper(), non_terminal))

class FileTemplate(object):
    def __init__(self, path, package, class_name):
        self.class_name = class_name
        self.package = package
        self.f = file("%s/%s/%s.kt" % (path, package.replace(".", "/"), class_name), "w")


    def init(self):
        self.write_line("package %s\n" % self.package)

    def start_class(self, type="class"):
        self.write_line("%s %s {\n" % (type, self.class_name))

    def end_class(self):
        self.write_line("}")

    def import_package(self, package):
        self.write_line("import %s\n" % package)


    def write_line(self, text, *args):
        self.f.write(text % args)
        self.f.write("\n")


class NonTerminals(FileTemplate):
    def __init__(self, path, package, class_name, ):
        super(NonTerminals, self).__init__(path, package, class_name)

    def construct(self):
        self.init()
        self.import_package("org.ocaml.lang.parser.OcamlNonTerminalElementType")
        self.start_class("object")
        for non_terminal in non_terminals:
            self.write_line('val %s = OcamlNonTerminalElementType("%s")\n' % (non_terminal.upper(), non_terminal))

        self.elementNameMap()
        self.createElement()
        self.end_class()

    def elementNameMap(self):
        self.write_line("val elementNameMap = mapOf(")
        self.write_line(",\n".join('Pair("%s", %s)' %(non_terminal, non_terminal.upper()) for non_terminal in non_terminals))
        self.write_line(")")


    def createElement(self):
        self.write_line("fun createElement(node: ASTNode): PsiElement  {")
        self.write_line("val type = node.getElementType()")
        self.write_line("when(type) {")
        for non_terminal in non_terminals:
            self.write_line("%s -> %s" % (non_terminal.upper(), snakeToClassCase(non_terminal)))
        self.write_line('else -> AssertionError("Unknown element type: " + type)')
        self.write_line("}")
        self.write_line("}")


def snakeToClassCase(s):
    def repl(m):
        return m.group(1).upper()
    r = re.compile("(?:^|_)([a-z])")
    return r.sub(repl, s)

if __name__ == "__main__":
    gp = NonTerminals(path, package, "OcamlNonTerminals")
    gp.construct()



# Generate interfaces
# Generate impls
# Generate converter
