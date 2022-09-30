import java.util.ArrayList;
import java.util.List;

public class Math_experssion {
	
	public enum LexemeType {
		LEFT_BRACKET, RIGHT_BRACKET, 
		OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
		NUMBER, 		// �����
		EOF;			// ����� ������
	}

		// ����� ��� ������������� ���������� ��������������� ���������
	public static class Lexeme {
		LexemeType type;
		String value;
		public Lexeme(LexemeType type, String value) {
			this.type = type;
			this.value = value;
		}
		public Lexeme(LexemeType type, Character value) {
			this.type = type;
			this.value = value.toString();
		}
		@Override
			public String toString() {
				return "Lexeme (" + "type = " + type + " , value = '" + value + '\'' + ")";
			}
		
	}
		// ��� ���������� ������� �� ������� ������
	public static class LexemeBuffer {
		private int pos;
		public List <Lexeme> lexemes;
		/**
		 * @param pos
		 * @param lexemes
		 */
		public LexemeBuffer(List<Lexeme> lexemes) {
			this.lexemes = lexemes;
		}
			// ����� ������� �� ������ � ���������� ��������
		public Lexeme next () {
			return lexemes.get(pos++);
		}
			// ����� �������� ����� �� ������
		public void back () {
			pos--;
		}
			// ����� ��������� ������ ������� �������
		public int getPos () {
			return pos;
		}
		
		
		
		
	}
		
		// ����� ��������� ������ � ���������� � ����� ��������������� �� � ������ Lexeme
	public static List<Lexeme> lexAnalyze (String expessionText) {
		ArrayList<Lexeme> lexemes = new ArrayList<Lexeme>();
		int position = 0;
		while (position < expessionText.length()) {
			char c = expessionText.charAt(position);
			switch (c) {
			case '(': 
				lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
				position++;
				continue;	// ���������� �������� � ������� � ������ ������ ����� while
			case ')': 
				lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
				position++;
				continue;
			case '+': 
				lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
				position++;
				continue;
			case '-':
				lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
				position++;
				continue;
			case '*':
				lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
				position++;
				continue;
			case '/':
				lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
				position++;
				continue;
			default:
				if (c<='9' && c>='0') {							// ������� ��������, ��� ������ ������ �������� ������
					StringBuilder sb = new StringBuilder();
					do {
						sb.append(c);
						position++;
						if (position>= expessionText.length()) break;
						c = expessionText.charAt(position);
					}
					while (c<='9' && c>='0');					// ���� ������ �� ��� ��� ���� ��� ����� ����� �� �������
					lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
				}
				else {
					if (c != ' ') {
						throw new RuntimeException("Unexpected character " + c);
					}
					position++;		// ������� �������
				}
			}
		}
		lexemes.add(new Lexeme(LexemeType.EOF, ""));			// ���������� ������ ����� ������
		return lexemes;
	}
	
	/* ������� ��������� ��������������� ��������� 
	 * expr : plusminus * EOF; 							 - EOF - ����� ������
	 * plusminus : multdiv (('+' | '-') multdiv )*;		 - �������� � ���������
	 * multdiv : factor (('*' | '/') factor )*;  		 - ������� � ���������
	 * factor : NUMBER | '(' expr ')';					 - �����  ��� �������� � �������
	 */
	
	public static int expr (LexemeBuffer lexemes) {
		Lexeme lexeme = lexemes.next();
		if (lexeme.type == LexemeType.EOF) {
			return 0;
		}
		else {
			lexemes.back();
			return plusminus(lexemes);
		}
	}

	public static int plusminus (LexemeBuffer lexemes) {
		int value = multdiv(lexemes);
		while (true) {
			Lexeme lexeme = lexemes.next();
			switch (lexeme.type) {
			case OP_PLUS: {
				value = value + multdiv(lexemes);
				break;
			}
			case OP_MINUS: {
				value = value - multdiv(lexemes);}
			default: {
				lexemes.back();
				return value;
			}
			}
		}
		
	}

	public static int multdiv (LexemeBuffer lexemes) {
		int value = factor(lexemes);
		while (true) {
			Lexeme lexeme = lexemes.next();
			switch (lexeme.type) {
			case OP_MUL: {
				value = value*factor(lexemes);
				break;
			}
			case OP_DIV: {
				value = value/factor(lexemes);}
			default: {
				lexemes.back();
				return value;
			}
			}
		}
	}

	public static int factor (LexemeBuffer lexemes) {
		Lexeme lexeme = lexemes.next();
		switch (lexeme.type) {
		case NUMBER: 
			return Integer.parseInt(lexeme.value);
		case LEFT_BRACKET:
			int value = expr(lexemes);
			lexeme = lexemes.next();
			if (lexeme.type != LexemeType.RIGHT_BRACKET) {
				throw new RuntimeException("Unexpected tocken: " + 	lexeme.value + " at position " + lexemes.getPos());
			}
			return value;
			default: {
				throw new RuntimeException("Unexpected tocken: " + 	lexeme.value + " at position " + lexemes.getPos());
			}
		}
}
	
	
public static void main(String[] args) {
	String expressionText = " 22 + 3 - 2*(2*5 + 2) / 4 ";
	List<Lexeme> lexemes = lexAnalyze(expressionText);
	LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
	System.out.println(expr(lexemeBuffer));


	
	}

}
