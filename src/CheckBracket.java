class CheckBracket
{
    private String input;

    public CheckBracket(String in)
    { input = in; }

    public void check()
    {
        int stackSize = input.length();
        Stack theStack = new Stack(stackSize);
        Stack stackForCheck = new Stack(stackSize);
        for(int j=0; j<input.length(); j++)
        {
            char ch = input.charAt(j);

            switch(ch)
            {
                case '{':      // Открывающие скобки
                case '[':
                case '(':

                    if(  !theStack.isEmpty() )  // Если стек не пуст,
                       {
                        char previous = theStack.pop();
                           if  (  ch=='{' &&  ( previous =='(' )
                               || ch=='(' &&  ( previous=='[' )
                               )
                           System.out.println("Error: нельзя ставить "+previous+" перед "+ch
                                   + "  в позиции: "+j);

                               theStack.push(previous);
                               theStack.push(ch);}
                    else{

                         theStack.push(ch); }

                    break;
                case '}':      // Закрывающие скобки
                case ']':
                case ')':
                    if( !stackForCheck.isEmpty() )
                    { char check= stackForCheck.pop();
                        if(
                                        (ch==']' && (check ==')'|| check=='}') ) ||
                                        (ch==')' &&  check=='}')
                        )
//                            System.out.println("Error3: "+ch+" at "+j);
                        System.out.println("Error:  нельзя вводить "+ch+"  после "+check+
                                " в позиции: "+j);
                    }
                    if( !theStack.isEmpty() )
                    {
                        char chx = theStack.pop();

                        if(     (ch=='}' && chx!='{') ||
                                 (ch==']' &&  chx!='[') ||
                                 (ch==')' &&   chx!='(')
                          )
                            { System.out.println("Error: "+ch+" at "+j);
                                         }
                    }
                    else                                                  // Стек пуст
                        System.out.println("Error: "+ch+" at "+j);
                    stackForCheck.push(ch);
                    break;
                default:

                    break;
            }
        }
        if( !theStack.isEmpty() )
        System.out.println("Error:   Лишние правые скобки");
    }
}
