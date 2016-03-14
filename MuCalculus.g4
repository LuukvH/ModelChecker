grammar MuCalculus;

formulae : mfalse | mtrue | endrecursion | conjunction | disjunction | diamond | box | leastfixpoint | greatestfixpoint;

conjunction : '(' left '&&' right ')';
disjunction : '(' left '||' right ')';
diamond : '<' label '>' formulae;
box : '[' label ']' formulae;

leastfixpoint : 'mu' startrecursion '.' formulae;
greatestfixpoint : 'nu' startrecursion '.' formulae;

left : formulae;
right : formulae;
label : STRING;
mfalse : FALSE;
mtrue : TRUE;
startrecursion : RECURSIONVARIABLE;
endrecursion : RECURSIONVARIABLE;

FALSE : 'false';
TRUE : 'true';
NUMBER : [0-9]+;
STRING : [a-z0-9]+;
RECURSIONVARIABLE : [A-Z];
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip;
