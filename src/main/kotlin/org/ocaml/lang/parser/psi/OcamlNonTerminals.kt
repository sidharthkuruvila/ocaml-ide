package org.ocaml.lang.parser.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.ocaml.lang.parser.OcamlNonTerminalElementType

object OcamlNonTerminals {

val IMPLEMENTATION = OcamlNonTerminalElementType("implementation")

val INTERFACE = OcamlNonTerminalElementType("interface")

val TOPLEVEL_PHRASE = OcamlNonTerminalElementType("toplevel_phrase")

val TOP_STRUCTURE = OcamlNonTerminalElementType("top_structure")

val TOP_STRUCTURE_TAIL = OcamlNonTerminalElementType("top_structure_tail")

val USE_FILE = OcamlNonTerminalElementType("use_file")

val USE_FILE_BODY = OcamlNonTerminalElementType("use_file_body")

val USE_FILE_TAIL = OcamlNonTerminalElementType("use_file_tail")

val PARSE_CORE_TYPE = OcamlNonTerminalElementType("parse_core_type")

val PARSE_EXPRESSION = OcamlNonTerminalElementType("parse_expression")

val PARSE_PATTERN = OcamlNonTerminalElementType("parse_pattern")

val FUNCTOR_ARG = OcamlNonTerminalElementType("functor_arg")

val FUNCTOR_ARG_NAME = OcamlNonTerminalElementType("functor_arg_name")

val FUNCTOR_ARGS = OcamlNonTerminalElementType("functor_args")

val MODULE_EXPR = OcamlNonTerminalElementType("module_expr")

val STRUCTURE = OcamlNonTerminalElementType("structure")

val STRUCTURE_TAIL = OcamlNonTerminalElementType("structure_tail")

val STRUCTURE_ITEM = OcamlNonTerminalElementType("structure_item")

val STR_INCLUDE_STATEMENT = OcamlNonTerminalElementType("str_include_statement")

val MODULE_BINDING_BODY = OcamlNonTerminalElementType("module_binding_body")

val MODULE_BINDING = OcamlNonTerminalElementType("module_binding")

val REC_MODULE_BINDINGS = OcamlNonTerminalElementType("rec_module_bindings")

val REC_MODULE_BINDING = OcamlNonTerminalElementType("rec_module_binding")

val AND_MODULE_BINDING = OcamlNonTerminalElementType("and_module_binding")

val MODULE_TYPE = OcamlNonTerminalElementType("module_type")

val SIGNATURE = OcamlNonTerminalElementType("signature")

val SIGNATURE_ITEM = OcamlNonTerminalElementType("signature_item")

val OPEN_STATEMENT = OcamlNonTerminalElementType("open_statement")

val SIG_INCLUDE_STATEMENT = OcamlNonTerminalElementType("sig_include_statement")

val MODULE_DECLARATION_BODY = OcamlNonTerminalElementType("module_declaration_body")

val MODULE_DECLARATION = OcamlNonTerminalElementType("module_declaration")

val MODULE_ALIAS = OcamlNonTerminalElementType("module_alias")

val REC_MODULE_DECLARATIONS = OcamlNonTerminalElementType("rec_module_declarations")

val REC_MODULE_DECLARATION = OcamlNonTerminalElementType("rec_module_declaration")

val AND_MODULE_DECLARATION = OcamlNonTerminalElementType("and_module_declaration")

val MODULE_TYPE_DECLARATION_BODY = OcamlNonTerminalElementType("module_type_declaration_body")

val MODULE_TYPE_DECLARATION = OcamlNonTerminalElementType("module_type_declaration")

val CLASS_DECLARATIONS = OcamlNonTerminalElementType("class_declarations")

val CLASS_DECLARATION = OcamlNonTerminalElementType("class_declaration")

val AND_CLASS_DECLARATION = OcamlNonTerminalElementType("and_class_declaration")

val CLASS_FUN_BINDING = OcamlNonTerminalElementType("class_fun_binding")

val CLASS_TYPE_PARAMETERS = OcamlNonTerminalElementType("class_type_parameters")

val CLASS_FUN_DEF = OcamlNonTerminalElementType("class_fun_def")

val CLASS_EXPR = OcamlNonTerminalElementType("class_expr")

val CLASS_SIMPLE_EXPR = OcamlNonTerminalElementType("class_simple_expr")

val CLASS_STRUCTURE = OcamlNonTerminalElementType("class_structure")

val CLASS_SELF_PATTERN = OcamlNonTerminalElementType("class_self_pattern")

val CLASS_FIELDS = OcamlNonTerminalElementType("class_fields")

val CLASS_FIELD = OcamlNonTerminalElementType("class_field")

val PARENT_BINDER = OcamlNonTerminalElementType("parent_binder")

val VALUE = OcamlNonTerminalElementType("value")

val METHOD_ = OcamlNonTerminalElementType("method_")

val CLASS_TYPE = OcamlNonTerminalElementType("class_type")

val CLASS_SIGNATURE = OcamlNonTerminalElementType("class_signature")

val CLASS_SIG_BODY = OcamlNonTerminalElementType("class_sig_body")

val CLASS_SELF_TYPE = OcamlNonTerminalElementType("class_self_type")

val CLASS_SIG_FIELDS = OcamlNonTerminalElementType("class_sig_fields")

val CLASS_SIG_FIELD = OcamlNonTerminalElementType("class_sig_field")

val VALUE_TYPE = OcamlNonTerminalElementType("value_type")

val CONSTRAIN = OcamlNonTerminalElementType("constrain")

val CONSTRAIN_FIELD = OcamlNonTerminalElementType("constrain_field")

val CLASS_DESCRIPTIONS = OcamlNonTerminalElementType("class_descriptions")

val CLASS_DESCRIPTION = OcamlNonTerminalElementType("class_description")

val AND_CLASS_DESCRIPTION = OcamlNonTerminalElementType("and_class_description")

val CLASS_TYPE_DECLARATIONS = OcamlNonTerminalElementType("class_type_declarations")

val CLASS_TYPE_DECLARATION = OcamlNonTerminalElementType("class_type_declaration")

val AND_CLASS_TYPE_DECLARATION = OcamlNonTerminalElementType("and_class_type_declaration")

val SEQ_EXPR = OcamlNonTerminalElementType("seq_expr")

val LABELED_SIMPLE_PATTERN = OcamlNonTerminalElementType("labeled_simple_pattern")

val PATTERN_VAR = OcamlNonTerminalElementType("pattern_var")

val OPT_DEFAULT = OcamlNonTerminalElementType("opt_default")

val LABEL_LET_PATTERN = OcamlNonTerminalElementType("label_let_pattern")

val LABEL_VAR = OcamlNonTerminalElementType("label_var")

val LET_PATTERN = OcamlNonTerminalElementType("let_pattern")

val EXPR = OcamlNonTerminalElementType("expr")

val SIMPLE_EXPR = OcamlNonTerminalElementType("simple_expr")

val SIMPLE_LABELED_EXPR_LIST = OcamlNonTerminalElementType("simple_labeled_expr_list")

val LABELED_SIMPLE_EXPR = OcamlNonTerminalElementType("labeled_simple_expr")

val LABEL_EXPR = OcamlNonTerminalElementType("label_expr")

val LABEL_IDENT = OcamlNonTerminalElementType("label_ident")

val LIDENT_LIST = OcamlNonTerminalElementType("lident_list")

val LET_BINDING_BODY = OcamlNonTerminalElementType("let_binding_body")

val LET_BINDINGS = OcamlNonTerminalElementType("let_bindings")

val LET_BINDING = OcamlNonTerminalElementType("let_binding")

val AND_LET_BINDING = OcamlNonTerminalElementType("and_let_binding")

val FUN_BINDING = OcamlNonTerminalElementType("fun_binding")

val STRICT_BINDING = OcamlNonTerminalElementType("strict_binding")

val MATCH_CASES = OcamlNonTerminalElementType("match_cases")

val MATCH_CASE = OcamlNonTerminalElementType("match_case")

val FUN_DEF = OcamlNonTerminalElementType("fun_def")

val EXPR_COMMA_LIST = OcamlNonTerminalElementType("expr_comma_list")

val RECORD_EXPR = OcamlNonTerminalElementType("record_expr")

val LBL_EXPR_LIST = OcamlNonTerminalElementType("lbl_expr_list")

val LBL_EXPR = OcamlNonTerminalElementType("lbl_expr")

val FIELD_EXPR_LIST = OcamlNonTerminalElementType("field_expr_list")

val FIELD_EXPR = OcamlNonTerminalElementType("field_expr")

val EXPR_SEMI_LIST = OcamlNonTerminalElementType("expr_semi_list")

val TYPE_CONSTRAINT = OcamlNonTerminalElementType("type_constraint")

val OPT_TYPE_CONSTRAINT = OcamlNonTerminalElementType("opt_type_constraint")

val PATTERN = OcamlNonTerminalElementType("pattern")

val PATTERN_NO_EXN = OcamlNonTerminalElementType("pattern_no_exn")

val PATTERN_GEN = OcamlNonTerminalElementType("pattern_gen")

val SIMPLE_PATTERN = OcamlNonTerminalElementType("simple_pattern")

val SIMPLE_PATTERN_NOT_IDENT = OcamlNonTerminalElementType("simple_pattern_not_ident")

val PATTERN_COMMA_LIST = OcamlNonTerminalElementType("pattern_comma_list")

val PATTERN_NO_EXN_COMMA_LIST = OcamlNonTerminalElementType("pattern_no_exn_comma_list")

val PATTERN_SEMI_LIST = OcamlNonTerminalElementType("pattern_semi_list")

val LBL_PATTERN_LIST = OcamlNonTerminalElementType("lbl_pattern_list")

val LBL_PATTERN = OcamlNonTerminalElementType("lbl_pattern")

val OPT_PATTERN_TYPE_CONSTRAINT = OcamlNonTerminalElementType("opt_pattern_type_constraint")

val VALUE_DESCRIPTION = OcamlNonTerminalElementType("value_description")

val PRIMITIVE_DECLARATION_BODY = OcamlNonTerminalElementType("primitive_declaration_body")

val PRIMITIVE_DECLARATION = OcamlNonTerminalElementType("primitive_declaration")

val TYPE_DECLARATIONS = OcamlNonTerminalElementType("type_declarations")

val TYPE_DECLARATION = OcamlNonTerminalElementType("type_declaration")

val AND_TYPE_DECLARATION = OcamlNonTerminalElementType("and_type_declaration")

val CONSTRAINTS = OcamlNonTerminalElementType("constraints")

val TYPE_KIND = OcamlNonTerminalElementType("type_kind")

val OPTIONAL_TYPE_PARAMETERS = OcamlNonTerminalElementType("optional_type_parameters")

val OPTIONAL_TYPE_PARAMETER = OcamlNonTerminalElementType("optional_type_parameter")

val OPTIONAL_TYPE_PARAMETER_LIST = OcamlNonTerminalElementType("optional_type_parameter_list")

val OPTIONAL_TYPE_VARIABLE = OcamlNonTerminalElementType("optional_type_variable")

val TYPE_PARAMETERS = OcamlNonTerminalElementType("type_parameters")

val TYPE_PARAMETER = OcamlNonTerminalElementType("type_parameter")

val TYPE_VARIANCE = OcamlNonTerminalElementType("type_variance")

val TYPE_VARIABLE = OcamlNonTerminalElementType("type_variable")

val TYPE_PARAMETER_LIST = OcamlNonTerminalElementType("type_parameter_list")

val CONSTRUCTOR_DECLARATIONS = OcamlNonTerminalElementType("constructor_declarations")

val CONSTRUCTOR_DECLARATION = OcamlNonTerminalElementType("constructor_declaration")

val BAR_CONSTRUCTOR_DECLARATION = OcamlNonTerminalElementType("bar_constructor_declaration")

val STR_EXCEPTION_DECLARATION = OcamlNonTerminalElementType("str_exception_declaration")

val SIG_EXCEPTION_DECLARATION = OcamlNonTerminalElementType("sig_exception_declaration")

val GENERALIZED_CONSTRUCTOR_ARGUMENTS = OcamlNonTerminalElementType("generalized_constructor_arguments")

val CONSTRUCTOR_ARGUMENTS = OcamlNonTerminalElementType("constructor_arguments")

val LABEL_DECLARATIONS = OcamlNonTerminalElementType("label_declarations")

val LABEL_DECLARATION = OcamlNonTerminalElementType("label_declaration")

val LABEL_DECLARATION_SEMI = OcamlNonTerminalElementType("label_declaration_semi")

val STR_TYPE_EXTENSION = OcamlNonTerminalElementType("str_type_extension")

val SIG_TYPE_EXTENSION = OcamlNonTerminalElementType("sig_type_extension")

val STR_EXTENSION_CONSTRUCTORS = OcamlNonTerminalElementType("str_extension_constructors")

val SIG_EXTENSION_CONSTRUCTORS = OcamlNonTerminalElementType("sig_extension_constructors")

val EXTENSION_CONSTRUCTOR_DECLARATION = OcamlNonTerminalElementType("extension_constructor_declaration")

val BAR_EXTENSION_CONSTRUCTOR_DECLARATION = OcamlNonTerminalElementType("bar_extension_constructor_declaration")

val EXTENSION_CONSTRUCTOR_REBIND = OcamlNonTerminalElementType("extension_constructor_rebind")

val BAR_EXTENSION_CONSTRUCTOR_REBIND = OcamlNonTerminalElementType("bar_extension_constructor_rebind")

val WITH_CONSTRAINTS = OcamlNonTerminalElementType("with_constraints")

val WITH_CONSTRAINT = OcamlNonTerminalElementType("with_constraint")

val WITH_TYPE_BINDER = OcamlNonTerminalElementType("with_type_binder")

val TYPEVAR_LIST = OcamlNonTerminalElementType("typevar_list")

val POLY_TYPE = OcamlNonTerminalElementType("poly_type")

val POLY_TYPE_NO_ATTR = OcamlNonTerminalElementType("poly_type_no_attr")

val CORE_TYPE = OcamlNonTerminalElementType("core_type")

val CORE_TYPE_NO_ATTR = OcamlNonTerminalElementType("core_type_no_attr")

val CORE_TYPE2 = OcamlNonTerminalElementType("core_type2")

val SIMPLE_CORE_TYPE = OcamlNonTerminalElementType("simple_core_type")

val SIMPLE_CORE_TYPE2 = OcamlNonTerminalElementType("simple_core_type2")

val PACKAGE_TYPE = OcamlNonTerminalElementType("package_type")

val ROW_FIELD_LIST = OcamlNonTerminalElementType("row_field_list")

val ROW_FIELD = OcamlNonTerminalElementType("row_field")

val TAG_FIELD = OcamlNonTerminalElementType("tag_field")

val OPT_AMPERSAND = OcamlNonTerminalElementType("opt_ampersand")

val AMPER_TYPE_LIST = OcamlNonTerminalElementType("amper_type_list")

val NAME_TAG_LIST = OcamlNonTerminalElementType("name_tag_list")

val SIMPLE_CORE_TYPE_OR_TUPLE = OcamlNonTerminalElementType("simple_core_type_or_tuple")

val CORE_TYPE_COMMA_LIST = OcamlNonTerminalElementType("core_type_comma_list")

val CORE_TYPE_LIST = OcamlNonTerminalElementType("core_type_list")

val METH_LIST = OcamlNonTerminalElementType("meth_list")

val FIELD = OcamlNonTerminalElementType("field")

val FIELD_SEMI = OcamlNonTerminalElementType("field_semi")

val LABEL = OcamlNonTerminalElementType("label")

val CONSTANT = OcamlNonTerminalElementType("constant")

val SIGNED_CONSTANT = OcamlNonTerminalElementType("signed_constant")

val IDENT = OcamlNonTerminalElementType("ident")

val VAL_IDENT = OcamlNonTerminalElementType("val_ident")

val OPERATOR = OcamlNonTerminalElementType("operator")

val CONSTR_IDENT = OcamlNonTerminalElementType("constr_ident")

val VAL_LONGIDENT = OcamlNonTerminalElementType("val_longident")

val CONSTR_LONGIDENT = OcamlNonTerminalElementType("constr_longident")

val LABEL_LONGIDENT = OcamlNonTerminalElementType("label_longident")

val TYPE_LONGIDENT = OcamlNonTerminalElementType("type_longident")

val MOD_LONGIDENT = OcamlNonTerminalElementType("mod_longident")

val MOD_EXT_LONGIDENT = OcamlNonTerminalElementType("mod_ext_longident")

val MTY_LONGIDENT = OcamlNonTerminalElementType("mty_longident")

val CLTY_LONGIDENT = OcamlNonTerminalElementType("clty_longident")

val CLASS_LONGIDENT = OcamlNonTerminalElementType("class_longident")

val TOPLEVEL_DIRECTIVE = OcamlNonTerminalElementType("toplevel_directive")

val NAME_TAG = OcamlNonTerminalElementType("name_tag")

val REC_FLAG = OcamlNonTerminalElementType("rec_flag")

val NONREC_FLAG = OcamlNonTerminalElementType("nonrec_flag")

val DIRECTION_FLAG = OcamlNonTerminalElementType("direction_flag")

val PRIVATE_FLAG = OcamlNonTerminalElementType("private_flag")

val MUTABLE_FLAG = OcamlNonTerminalElementType("mutable_flag")

val VIRTUAL_FLAG = OcamlNonTerminalElementType("virtual_flag")

val PRIVATE_VIRTUAL_FLAGS = OcamlNonTerminalElementType("private_virtual_flags")

val OVERRIDE_FLAG = OcamlNonTerminalElementType("override_flag")

val OPT_BAR = OcamlNonTerminalElementType("opt_bar")

val OPT_SEMI = OcamlNonTerminalElementType("opt_semi")

val SUBTRACTIVE = OcamlNonTerminalElementType("subtractive")

val ADDITIVE = OcamlNonTerminalElementType("additive")

val SINGLE_ATTR_ID = OcamlNonTerminalElementType("single_attr_id")

val ATTR_ID = OcamlNonTerminalElementType("attr_id")

val ATTRIBUTE = OcamlNonTerminalElementType("attribute")

val POST_ITEM_ATTRIBUTE = OcamlNonTerminalElementType("post_item_attribute")

val FLOATING_ATTRIBUTE = OcamlNonTerminalElementType("floating_attribute")

val POST_ITEM_ATTRIBUTES = OcamlNonTerminalElementType("post_item_attributes")

val ATTRIBUTES = OcamlNonTerminalElementType("attributes")

val EXT_ATTRIBUTES = OcamlNonTerminalElementType("ext_attributes")

val EXTENSION = OcamlNonTerminalElementType("extension")

val ITEM_EXTENSION = OcamlNonTerminalElementType("item_extension")

val PAYLOAD = OcamlNonTerminalElementType("payload")

val elementNameMap = mapOf(
Pair("implementation", IMPLEMENTATION),
Pair("interface", INTERFACE),
Pair("toplevel_phrase", TOPLEVEL_PHRASE),
Pair("top_structure", TOP_STRUCTURE),
Pair("top_structure_tail", TOP_STRUCTURE_TAIL),
Pair("use_file", USE_FILE),
Pair("use_file_body", USE_FILE_BODY),
Pair("use_file_tail", USE_FILE_TAIL),
Pair("parse_core_type", PARSE_CORE_TYPE),
Pair("parse_expression", PARSE_EXPRESSION),
Pair("parse_pattern", PARSE_PATTERN),
Pair("functor_arg", FUNCTOR_ARG),
Pair("functor_arg_name", FUNCTOR_ARG_NAME),
Pair("functor_args", FUNCTOR_ARGS),
Pair("module_expr", MODULE_EXPR),
Pair("structure", STRUCTURE),
Pair("structure_tail", STRUCTURE_TAIL),
Pair("structure_item", STRUCTURE_ITEM),
Pair("str_include_statement", STR_INCLUDE_STATEMENT),
Pair("module_binding_body", MODULE_BINDING_BODY),
Pair("module_binding", MODULE_BINDING),
Pair("rec_module_bindings", REC_MODULE_BINDINGS),
Pair("rec_module_binding", REC_MODULE_BINDING),
Pair("and_module_binding", AND_MODULE_BINDING),
Pair("module_type", MODULE_TYPE),
Pair("signature", SIGNATURE),
Pair("signature_item", SIGNATURE_ITEM),
Pair("open_statement", OPEN_STATEMENT),
Pair("sig_include_statement", SIG_INCLUDE_STATEMENT),
Pair("module_declaration_body", MODULE_DECLARATION_BODY),
Pair("module_declaration", MODULE_DECLARATION),
Pair("module_alias", MODULE_ALIAS),
Pair("rec_module_declarations", REC_MODULE_DECLARATIONS),
Pair("rec_module_declaration", REC_MODULE_DECLARATION),
Pair("and_module_declaration", AND_MODULE_DECLARATION),
Pair("module_type_declaration_body", MODULE_TYPE_DECLARATION_BODY),
Pair("module_type_declaration", MODULE_TYPE_DECLARATION),
Pair("class_declarations", CLASS_DECLARATIONS),
Pair("class_declaration", CLASS_DECLARATION),
Pair("and_class_declaration", AND_CLASS_DECLARATION),
Pair("class_fun_binding", CLASS_FUN_BINDING),
Pair("class_type_parameters", CLASS_TYPE_PARAMETERS),
Pair("class_fun_def", CLASS_FUN_DEF),
Pair("class_expr", CLASS_EXPR),
Pair("class_simple_expr", CLASS_SIMPLE_EXPR),
Pair("class_structure", CLASS_STRUCTURE),
Pair("class_self_pattern", CLASS_SELF_PATTERN),
Pair("class_fields", CLASS_FIELDS),
Pair("class_field", CLASS_FIELD),
Pair("parent_binder", PARENT_BINDER),
Pair("value", VALUE),
Pair("method_", METHOD_),
Pair("class_type", CLASS_TYPE),
Pair("class_signature", CLASS_SIGNATURE),
Pair("class_sig_body", CLASS_SIG_BODY),
Pair("class_self_type", CLASS_SELF_TYPE),
Pair("class_sig_fields", CLASS_SIG_FIELDS),
Pair("class_sig_field", CLASS_SIG_FIELD),
Pair("value_type", VALUE_TYPE),
Pair("constrain", CONSTRAIN),
Pair("constrain_field", CONSTRAIN_FIELD),
Pair("class_descriptions", CLASS_DESCRIPTIONS),
Pair("class_description", CLASS_DESCRIPTION),
Pair("and_class_description", AND_CLASS_DESCRIPTION),
Pair("class_type_declarations", CLASS_TYPE_DECLARATIONS),
Pair("class_type_declaration", CLASS_TYPE_DECLARATION),
Pair("and_class_type_declaration", AND_CLASS_TYPE_DECLARATION),
Pair("seq_expr", SEQ_EXPR),
Pair("labeled_simple_pattern", LABELED_SIMPLE_PATTERN),
Pair("pattern_var", PATTERN_VAR),
Pair("opt_default", OPT_DEFAULT),
Pair("label_let_pattern", LABEL_LET_PATTERN),
Pair("label_var", LABEL_VAR),
Pair("let_pattern", LET_PATTERN),
Pair("expr", EXPR),
Pair("simple_expr", SIMPLE_EXPR),
Pair("simple_labeled_expr_list", SIMPLE_LABELED_EXPR_LIST),
Pair("labeled_simple_expr", LABELED_SIMPLE_EXPR),
Pair("label_expr", LABEL_EXPR),
Pair("label_ident", LABEL_IDENT),
Pair("lident_list", LIDENT_LIST),
Pair("let_binding_body", LET_BINDING_BODY),
Pair("let_bindings", LET_BINDINGS),
Pair("let_binding", LET_BINDING),
Pair("and_let_binding", AND_LET_BINDING),
Pair("fun_binding", FUN_BINDING),
Pair("strict_binding", STRICT_BINDING),
Pair("match_cases", MATCH_CASES),
Pair("match_case", MATCH_CASE),
Pair("fun_def", FUN_DEF),
Pair("expr_comma_list", EXPR_COMMA_LIST),
Pair("record_expr", RECORD_EXPR),
Pair("lbl_expr_list", LBL_EXPR_LIST),
Pair("lbl_expr", LBL_EXPR),
Pair("field_expr_list", FIELD_EXPR_LIST),
Pair("field_expr", FIELD_EXPR),
Pair("expr_semi_list", EXPR_SEMI_LIST),
Pair("type_constraint", TYPE_CONSTRAINT),
Pair("opt_type_constraint", OPT_TYPE_CONSTRAINT),
Pair("pattern", PATTERN),
Pair("pattern_no_exn", PATTERN_NO_EXN),
Pair("pattern_gen", PATTERN_GEN),
Pair("simple_pattern", SIMPLE_PATTERN),
Pair("simple_pattern_not_ident", SIMPLE_PATTERN_NOT_IDENT),
Pair("pattern_comma_list", PATTERN_COMMA_LIST),
Pair("pattern_no_exn_comma_list", PATTERN_NO_EXN_COMMA_LIST),
Pair("pattern_semi_list", PATTERN_SEMI_LIST),
Pair("lbl_pattern_list", LBL_PATTERN_LIST),
Pair("lbl_pattern", LBL_PATTERN),
Pair("opt_pattern_type_constraint", OPT_PATTERN_TYPE_CONSTRAINT),
Pair("value_description", VALUE_DESCRIPTION),
Pair("primitive_declaration_body", PRIMITIVE_DECLARATION_BODY),
Pair("primitive_declaration", PRIMITIVE_DECLARATION),
Pair("type_declarations", TYPE_DECLARATIONS),
Pair("type_declaration", TYPE_DECLARATION),
Pair("and_type_declaration", AND_TYPE_DECLARATION),
Pair("constraints", CONSTRAINTS),
Pair("type_kind", TYPE_KIND),
Pair("optional_type_parameters", OPTIONAL_TYPE_PARAMETERS),
Pair("optional_type_parameter", OPTIONAL_TYPE_PARAMETER),
Pair("optional_type_parameter_list", OPTIONAL_TYPE_PARAMETER_LIST),
Pair("optional_type_variable", OPTIONAL_TYPE_VARIABLE),
Pair("type_parameters", TYPE_PARAMETERS),
Pair("type_parameter", TYPE_PARAMETER),
Pair("type_variance", TYPE_VARIANCE),
Pair("type_variable", TYPE_VARIABLE),
Pair("type_parameter_list", TYPE_PARAMETER_LIST),
Pair("constructor_declarations", CONSTRUCTOR_DECLARATIONS),
Pair("constructor_declaration", CONSTRUCTOR_DECLARATION),
Pair("bar_constructor_declaration", BAR_CONSTRUCTOR_DECLARATION),
Pair("str_exception_declaration", STR_EXCEPTION_DECLARATION),
Pair("sig_exception_declaration", SIG_EXCEPTION_DECLARATION),
Pair("generalized_constructor_arguments", GENERALIZED_CONSTRUCTOR_ARGUMENTS),
Pair("constructor_arguments", CONSTRUCTOR_ARGUMENTS),
Pair("label_declarations", LABEL_DECLARATIONS),
Pair("label_declaration", LABEL_DECLARATION),
Pair("label_declaration_semi", LABEL_DECLARATION_SEMI),
Pair("str_type_extension", STR_TYPE_EXTENSION),
Pair("sig_type_extension", SIG_TYPE_EXTENSION),
Pair("str_extension_constructors", STR_EXTENSION_CONSTRUCTORS),
Pair("sig_extension_constructors", SIG_EXTENSION_CONSTRUCTORS),
Pair("extension_constructor_declaration", EXTENSION_CONSTRUCTOR_DECLARATION),
Pair("bar_extension_constructor_declaration", BAR_EXTENSION_CONSTRUCTOR_DECLARATION),
Pair("extension_constructor_rebind", EXTENSION_CONSTRUCTOR_REBIND),
Pair("bar_extension_constructor_rebind", BAR_EXTENSION_CONSTRUCTOR_REBIND),
Pair("with_constraints", WITH_CONSTRAINTS),
Pair("with_constraint", WITH_CONSTRAINT),
Pair("with_type_binder", WITH_TYPE_BINDER),
Pair("typevar_list", TYPEVAR_LIST),
Pair("poly_type", POLY_TYPE),
Pair("poly_type_no_attr", POLY_TYPE_NO_ATTR),
Pair("core_type", CORE_TYPE),
Pair("core_type_no_attr", CORE_TYPE_NO_ATTR),
Pair("core_type2", CORE_TYPE2),
Pair("simple_core_type", SIMPLE_CORE_TYPE),
Pair("simple_core_type2", SIMPLE_CORE_TYPE2),
Pair("package_type", PACKAGE_TYPE),
Pair("row_field_list", ROW_FIELD_LIST),
Pair("row_field", ROW_FIELD),
Pair("tag_field", TAG_FIELD),
Pair("opt_ampersand", OPT_AMPERSAND),
Pair("amper_type_list", AMPER_TYPE_LIST),
Pair("name_tag_list", NAME_TAG_LIST),
Pair("simple_core_type_or_tuple", SIMPLE_CORE_TYPE_OR_TUPLE),
Pair("core_type_comma_list", CORE_TYPE_COMMA_LIST),
Pair("core_type_list", CORE_TYPE_LIST),
Pair("meth_list", METH_LIST),
Pair("field", FIELD),
Pair("field_semi", FIELD_SEMI),
Pair("label", LABEL),
Pair("constant", CONSTANT),
Pair("signed_constant", SIGNED_CONSTANT),
Pair("ident", IDENT),
Pair("val_ident", VAL_IDENT),
Pair("operator", OPERATOR),
Pair("constr_ident", CONSTR_IDENT),
Pair("val_longident", VAL_LONGIDENT),
Pair("constr_longident", CONSTR_LONGIDENT),
Pair("label_longident", LABEL_LONGIDENT),
Pair("type_longident", TYPE_LONGIDENT),
Pair("mod_longident", MOD_LONGIDENT),
Pair("mod_ext_longident", MOD_EXT_LONGIDENT),
Pair("mty_longident", MTY_LONGIDENT),
Pair("clty_longident", CLTY_LONGIDENT),
Pair("class_longident", CLASS_LONGIDENT),
Pair("toplevel_directive", TOPLEVEL_DIRECTIVE),
Pair("name_tag", NAME_TAG),
Pair("rec_flag", REC_FLAG),
Pair("nonrec_flag", NONREC_FLAG),
Pair("direction_flag", DIRECTION_FLAG),
Pair("private_flag", PRIVATE_FLAG),
Pair("mutable_flag", MUTABLE_FLAG),
Pair("virtual_flag", VIRTUAL_FLAG),
Pair("private_virtual_flags", PRIVATE_VIRTUAL_FLAGS),
Pair("override_flag", OVERRIDE_FLAG),
Pair("opt_bar", OPT_BAR),
Pair("opt_semi", OPT_SEMI),
Pair("subtractive", SUBTRACTIVE),
Pair("additive", ADDITIVE),
Pair("single_attr_id", SINGLE_ATTR_ID),
Pair("attr_id", ATTR_ID),
Pair("attribute", ATTRIBUTE),
Pair("post_item_attribute", POST_ITEM_ATTRIBUTE),
Pair("floating_attribute", FLOATING_ATTRIBUTE),
Pair("post_item_attributes", POST_ITEM_ATTRIBUTES),
Pair("attributes", ATTRIBUTES),
Pair("ext_attributes", EXT_ATTRIBUTES),
Pair("extension", EXTENSION),
Pair("item_extension", ITEM_EXTENSION),
Pair("payload", PAYLOAD)
)
fun createElement(node: ASTNode): PsiElement {
throw AssertionError("Unknown element type: " + node.elementType)
}
}
