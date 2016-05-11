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
begin [@ identifier : val a : 'identifier [@@ identifier 123 ]] "abc" end