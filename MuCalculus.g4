grammar MuCalculus;

formulae : mfalse | mtrue | recursion | conjunction | disjunction | diamond | box | leastfixpoint | greatestfixpoint;

conjunction : '(' left '&&' right ')';
disjunction : '(' left '||' right ')';
diamond : '<' label '>' formulae;
box : '[' label ']' formulae;
leastfixpoint : 'mu' recursion '.' formulae;
greatestfixpoint : 'nu' recursion '.' formulae;

left : formulae;
right : formulae;
label : STRING;
mfalse : FALSE;
mtrue : TRUE;
recursion : RECURSIONVARIABLE;

FALSE : 'false';
TRUE : 'true';
NUMBER : [0-9]+;
STRING : [a-z]+;
RECURSIONVARIABLE : [A-Z];
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip;
