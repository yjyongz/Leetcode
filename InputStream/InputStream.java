mport java.io.*;

public class InputStream {
        public static void main(String[] args) throws IOException
                // in.nextTokenizer可能抛出这个异常
        {
                StreamTokenizer in = new StreamTokenizer(new BufferedReader(
                                        new InputStreamReader(System.in)));
                // 这句是io流包装来包装去，记住就好；
                PrintWriter out = new PrintWriter(
                                           new OutputStreamWriter(System.out));
                int a, b;
                while (in.nextToken() != StreamTokenizer.TT_EOF)
                // 用in.nextToken()读下一个标记，
                //StreamTokenizer.TT_EOF这个是个参数，就是EOF
                {
                        a = (int) in.nval;
                        // 读进来的是double型的，所以要转成int
                        in.nextToken();
                        // 读入b值（a的值是在while循环中读入的）
                        b = (int) in.nval;
                        out.println(a + b);
                        // in.sval ====> String
                }
                out.flush();
                // 刷新缓冲区，必须的，不然a+b会留在缓冲区
        }
}
