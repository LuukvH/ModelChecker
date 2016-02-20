grammar MuCalculus;

formulae : FALSE | TRUE | RECURSIONVARIABLE | conjunction | disjunction | diamond | box | leastfixpoint | greatestfixpoint;

conjunction : '(' formulae '&&' formulae ')';
disjunction : '(' formulae '&&' formulae ')';
diamond : '<' LITERAL '>' formulae;
box : '[' LITERAL ']' formulae;
leastfixpoint : 'mu' (' '*) RECURSIONVARIABLE (' '*) '.' formulae;
greatestfixpoint : 'nu' (' '*) RECURSIONVARIABLE (' '*) '.' formulae;

FALSE : 'false';
TRUE : 'true';
LITERAL : ('a'..'z');
RECURSIONVARIABLE : ('A'..'Z');
