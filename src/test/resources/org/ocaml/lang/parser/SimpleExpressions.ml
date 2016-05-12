identifier;
(!!);
123;
Mod.Mod;
[]; (); true; false;
`identifier; `ModuleName;
(1);
begin [@ identifier 123] "abc" end;
begin % when "abc" end;
begin [@ identifier : ;; ] "abc" end;
(*begin [@ identifier : 'identifier ] "abc" end;*)
begin [@ identifier : val a : 'identifier [@@ identifier 123 ]] "abc" end;
begin end;
("abc" : 'identifier);
abc def ~ghi ?klm ?opq:rst ~uvw:xyz;
(let rec f = "a" ; "b"
     and g: 'identifier = 1 in "c");
(let module SimpleModule = Mod.Mod in "abc");
(let exception SimpleException of 'identifier in "abc");
(let open ! SimpleModule in "abc");
(fun ?(identifier : 'identifier = 123) -> "abc")