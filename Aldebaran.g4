grammar Aldebaran;

kripkestructure : aut_header aut_edge*;

aut_header        :  'des (' first_state ',' nr_of_transitions ',' nr_of_states ')';
first_state       :  NUMBER;
nr_of_transitions :  NUMBER;
nr_of_states      :  NUMBER;

aut_edge    :  '(' start_state ',"' label '",' end_state ')';
start_state :  NUMBER;
label       :  STRING;
end_state   :  NUMBER;

NUMBER : [0-9]+;
STRING : [a-zA-Z0-9]+;
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip;
