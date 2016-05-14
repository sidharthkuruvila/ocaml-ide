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
(function a -> "a" | b -> "c");
(fun ?(identifier : 'identifier = 123) -> "abc");
(fun ?id:(exception abc | xyz [@ identifier 123] as a :: def, hji as d) -> 123);
(fun ?id: identifier -> 123);
(fun (type a b c) -> "a");
(match "abc" with | a -> 123);
(try 123; "abc" with | a -> 123);
(Mod1.Mod2 abc);
(`identifier "abc");
(`Identifier "abc");
(if true then 1 else 2);
(if true then 1);
(while true do 123 done);
(for i = 1 to 10 do 123 done);
(::)(1, 3);
1 :: 2 :: 3
