% facts

hero('Elder Titan').
hero('Enigma').
hero('Keeper of the Light').
hero('Io').
hero('Chaos Knight').
hero('Lina').
hero('Crystal Maiden').
hero('Tidehunter').
hero('Kunkka').
hero('Huskar').
hero('Dazzle').
hero('Timbersaw').
hero('Treant Protector').
hero('Mars').
hero('Zeus').
hero('Skywrath Mage').
hero('Vengeful Spirit').
hero('Anti-mage').
hero('Undying').
hero('Tinker').
hero('Templar Assasin').
hero('Tusk').
hero('Bristleback').

relatives('Elder Titan', 'Enigma').
relatives('Elder Titan', 'Keeper of the Light').
relatives('Elder Titan', 'Io').
relatives('Elder Titan', 'Chaos Knight').
relatives('Elder Titan', 'Lina').
relatives('Mars', 'Zeus').
relatives('Crystal Maiden', 'Lina').

enemies('Tidehunter', 'Kunkka').
enemies('Timbersaw', 'Treant Protector').
enemies('Tusk', 'Bristleback').
enemies('Tusk', 'Tinker').
enemies('Bristleback', 'Tinker').
enemies('Tinker', 'Templar Assasin').

lovers('Skywrath Mage' , 'Vengeful Spirit').

% rules
not_lovers(X, Y) :- \+ lovers(X, Y), \+ lovers(Y, X).

family(X, Y) :- relatives(X, Y); relatives(Y, X).
not_family(X, Y) :- \+ family(X, Y).
distant_family(X, Y) :- family(X, Z), family(Z, Y).

opponents(X, Y) :- enemies(X, Y); enemies(Y, X).
distant_opponents(X, Y) :- opponents(X, Z), opponents(Z, Y).

family_count(X, Count) :- findall(Y, family(X, Y), List), length(List, Count).

% queries

 /*
  * family_count('Elder Titan', Count).
  * opponents('Bristleback', 'Tusk').
  * distant_opponents('Tusk', 'Tinker').
  * distant_opponents('Tidehunter', 'Tinker').
  */