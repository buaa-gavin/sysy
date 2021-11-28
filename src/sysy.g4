grammar sysy;

//词法
CONST: 'const';
DOT: ',';
SEMI: ';';
INT: 'int';
EQUAL: '=';
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
RETURN: 'return';
ADD: '+';
SUB: '-';
NOT: '!';
MUL: '*';
DIV: '/';
MOD: '%';
IF: 'if';
ELSE: 'else';
LESS: '<';
GREATER: '>';
LESS_OR_EQUAL: '<=';
GREATER_OR_EQUAL: '>=';
LOGICAL_EQUAL: '==';
LOGICAL_NOT_EQUAL: '!=';
LOGICAL_AND: '&&';
LOGICAL_OR: '||';
DECIMAL_CONST: '0' | [1-9]([0-9])*;
OCTAL_CONST: '0'([0-7])+;
HEXADECIMAL_CONST:  ('0x' | '0X')([0-9] | [A-F] | [a-f])+;
IDENT: ('_' | [a-z] | [A-Z])('_' | [a-z] | [A-Z] | [0-9])*;
WHITE_SPACE: [ \t\r\n] -> skip;


//语法
compunit     : funcdef;
decl         : constdecl | vardecl;
constdecl    : CONST btype constdef ( DOT constdef )* SEMI;
btype        : INT;
constdef     : ident EQUAL constinitval;
constinitval : constexp;
constexp     : addexp;
vardecl      : btype vardef ( DOT vardef )* SEMI;
vardef       : ident
                | ident EQUAL initval;
initval      : exp ;
funcdef      : functype ident LPAREN RPAREN block; // 保证当前 ident 只为 "Main"
functype     : INT;
block        : LBRACE ( blockitem )* RBRACE;
blockitem    : decl | stmt;
stmt         : lval EQUAL exp SEMI
                | block
                | (exp)? SEMI
                | IF LPAREN cond RPAREN stmt (ELSE stmt)?
                | RETURN exp SEMI;
lval         : ident;
exp          : addexp;
cond         : lorexp;
unaryexp     : primaryexp | ident LPAREN (funcrparams)? RPAREN | unaryop unaryexp;
primaryexp   : LPAREN exp RPAREN | lval | number;
funcrparams  : exp ( DOT exp )*;
unaryop      : ADD | SUB | NOT;
addexp       : mulexp
                | addexp (ADD | SUB) mulexp;
mulexp       : unaryexp
                | mulexp (MUL | DIV | MOD) unaryexp;
relexp       : addexp
                | relexp (LESS | GREATER | LESS_OR_EQUAL | GREATER_OR_EQUAL) addexp;
eqexp        : relexp
                | eqexp (LOGICAL_EQUAL | LOGICAL_NOT_EQUAL) relexp;
landexp      : eqexp
                | landexp LOGICAL_AND eqexp;
lorexp       : landexp
                | lorexp LOGICAL_OR landexp;
ident        : IDENT;
number             : decimal_const | octal_const | hexadecimal_const;
decimal_const      : DECIMAL_CONST;
octal_const        : OCTAL_CONST;
hexadecimal_const  : HEXADECIMAL_CONST;