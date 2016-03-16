grammar Aldebaran;

aldebaran : aut_header aut_edge*;

aut_header        :  'des (' first_state ',' nr_of_transitions ',' nr_of_states ')' (NewLine | EOF);
first_state       :  NUMBER;
nr_of_transitions :  NUMBER;
nr_of_states      :  NUMBER;

aut_edge    :  '(' start_state ',"' label '",' end_state ')' (NewLine | EOF);
start_state :  NUMBER;
label       :  STRING;
end_state   :  NUMBER;

NUMBER : [0-9]+;
STRING : [a-zA-Z0-9]+;
WHITESPACE : ( '\t' | ' ' | '\u000C' )+ -> skip;
NewLine :  '\r'? '\n' | '\r' ;
