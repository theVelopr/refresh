package ch05.s11;

import javax.tools.ForwardingFileObject;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * I/O와 Stream
 * - I/O -> Input/Output (입출력)
 * - Java의 I/O 방식은 Node - Stream
 *  - Node : 데이터의 소스 또는 데이터의 목적지
 *  - 노드는 키보드(입력), 모니터(출력), 파일(입출력), 메모리(입출력), Database, 다른 프로그램
 *  - Stream : 노드로부터 데이터를 주고 받는 통로 (StreamAPI와는 연관이 없음)
 *      - 입력으로 사용되는 스트림과 출력으로 사용되는 스트림은 별개
 *      - 입출력을 함께 하는 것은 채널(Channel) - NIO(New Input/Output)
 */
public class Main {

    static void copyStream(InputStream input, OutputStream output) throws IOException {
        byte [] buff = new byte[1024];
        int read = 0;
        while ((read = input.read(buff)) > 0) {
            output.write(buff, 0, read);
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        /**
         * Input Stream/Reader
         *
         * Stream/Reader 등을 사용하는 이유
         *  - 노드(입출력 장치/파일/메모리 등)으로부터 데이터를 읽고 쓰는 기본적인 방식
         *    보통은 컴퓨터를 사용하지만, Embedded machine의 경우 Stream을 사용하는 경우가 많다.
         *    그래서 Scanner가 편리하긴 하지만, Stream/Reader 동작을 이히핼 필요가 있음.
         *
         * Stream
         *  - byte 단위로 읽고 쓰는 특징
         *  - 영어 알파벳은 byte 단위로 끊어도 되지만 한글 글자는 byte단위로 끊으면 읽고 쓸 수 없음
         */


        /*
        try (InputStream input = System.in) {
            int read = -1;
            while((read = input.read()) != -1) {
                System.out.printf("int: %d Char: %c\n", read, read);

                 // 1 2 <- Input
                 // int: 49 Char: 1
                 // int: 32 Char: (space)
                 // int: 50 Char: 2
                 // int: 32 Char: (space)
                 // int: 10 Char: (enter)

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        System.out.println();

        /*
        try (InputStream input = System.in) {
            int read = 0;
            byte [] bytes = new byte[512];
            while ((read = input.read(bytes)) != -1) {
                // 1 2 <- Input (1, space, 2, space, enter)
                System.out.println(Arrays.toString(bytes)); // [49, 32, 50, 32, 10, 0,..., 0] index from 0 - 511th
                System.out.println(read);  // 5
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        */

        System.out.println();

        // Stream의 Mark/reset 기능
        //todo 정확한 설명을 찾아봐야함.
        System.out.println(System.in.markSupported()); // true

        /*
        try(InputStream input = System.in) {
            int read = -1;
            while((read = input.read()) != 'q') { // 프로세스 종료
                System.out.printf("Int: %d Char: %c\n", read, read);
                if ((char)read == 'm') { // Int: 109 Char: m
                    // todo readlimit은 뭐지?
                    input.mark(32);
                }
                if ((char)read == 'r') { // 입력시, Int: 114 Char: r
                    // todo 정확히 어떻게 동작하는거지?
                    input.reset();
                    //break; // 없으면 fall-through 발생함
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /**
         * Output Stream/Writer
         * - 메모리를 Node로 하는 입출력
         *  - 입력 Node: char array
         *  - 출력 Node: char array
         */
        /*
        char [] memory = "메모리 입출력 테스트 입력".toCharArray();
        char [] cbuf = new char[4];
        int read = 0;
        try (CharArrayReader reader = new CharArrayReader(memory);
             CharArrayWriter writer = new CharArrayWriter();) {
            while ((read = reader.read(cbuf)) > 0) {
                writer.write(cbuf, 0, read);
                writer.write(cbuf);
            }
            System.out.println(Arrays.toString(writer.toCharArray()));
            // [메, 모, 리,  , 메, 모, 리,  , 입, 출, 력,  , 입, 출, 력,  , 테, 스, 트,  , 테, 스, 트,  , 입, 력, 입, 력, 트,  ]
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        //
        String filePath = "C:" + File.separator + "Users" +  File.separator
                + "deHong" + File.separator + "Documents" + File.separator
                + "workspace" + File.separator + "Temp" + File.separator + "MyTemp";
        System.out.println(filePath); // C:\Users\deHong\Documents\workspace\Temp\MyTemp
        System.out.println();

        File fileOne = new File(filePath); // Path만 표현 (Not file)
        // 가장 하위 폴더만 생성 (상위 폴더 없으면 실패)
        System.out.println(fileOne.mkdir()); // false
        // 경로에 있는 모든 폴더를 생성
        System.out.println(fileOne.mkdirs()); // false

        File fileTwo = new File(filePath, "file2.txt");
        fileTwo.createNewFile();

        File fileThree = new File(fileOne, "file3.txt");
        fileThree.createNewFile();

        File fileFour = new File(new URI("file:///C:/Users/deHong/Documents/workspace/Temp/MyTemp/file4.txt"));
        fileFour.createNewFile();
        fileFour.deleteOnExit(); // Temp 파일을 사용할 때 유용

        System.out.println(fileTwo.getName()); // file2.txt
        System.out.println(fileTwo.getParent()); // C:\Users\deHong\Documents\workspace\Temp\MyTemp
        // 절대 경로를 사용하는지를 물어봄
        System.out.println(fileTwo.isAbsolute()); // true
        // ..등을 모두 배제한 표준 표현법 사용
        System.out.println(fileTwo.getAbsolutePath()); // C:\Users\deHong\Documents\workspace\Temp\MyTemp\file2.txt
        System.out.println(fileTwo.getCanonicalFile()); // C:\Users\deHong\Documents\workspace\Temp\MyTemp\file2.txt
        System.out.println();

        System.out.println(fileOne.isDirectory()); // true
        System.out.println(fileTwo.isFile()); // true

        // String Array로 출력
        System.out.println(Arrays.toString(fileOne.list())); // [file2.txt, file3.txt, file4.txt]
        // File 객체를 Array로 출력
        System.out.println(Arrays.toString(fileOne.listFiles()));
        // [C:\Users\deHong\Documents\workspace\Temp\MyTemp\file2.txt,
        // C:\Users\deHong\Documents\workspace\Temp\MyTemp\file3.txt,
        // C:\Users\deHong\Documents\workspace\Temp\MyTemp\file4.txt]

        File srcFile = new File(fileOne, "scr.txt");
        File dstFile = new File(fileOne, "dst.txt");
        srcFile.createNewFile();
        //dstFile.createNewFile();

        // Stream을 이용한 파일의 복사 (byte 단위)
        // scr.txt -> dst.txt로 복사(?) 했음
        /*
        try (InputStream src = new FileInputStream(srcFile);
             OutputStream dst = new FileOutputStream(dstFile)) {
            // todo 초기화를 왜 -1로 했을까?
            int read = -1;
            while((read = src.read()) != -1) {
                dst.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*
        try (InputStream src = new FileInputStream(srcFile);
             OutputStream dst = new FileOutputStream(dstFile)) {
            int read = 0;
            byte [] buff = new byte[4];
            while ((read = src.read(buff)) > 0) {
                dst.write(buff, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        // Reader를 이용한 파일 복사 (char 단위)
        /*
        try (FileReader src = new FileReader(srcFile);
             FileWriter dst = new FileWriter(dstFile)) {
            int read = -1;
            while((read = src.read()) != -1) {
                dst.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        // append = true 로 FileWriter를 생성하면 이어서 작성 (txt, ini, properties, ..)
        // binary 파일에는 잘 사용하지 않음
        // binary 파일 - 문자열로 작성된 것이 아닌, decoding이 된 상태의 파일
        //  그림파일, 동영상, exe 파일 ...
        /*
        try (FileReader src = new FileReader(srcFile);
             FileWriter dst = new FileWriter(dstFile, true)) {
            int read= 0;
            char [] buff = new char[4];
            while((read = src.read(buff)) > 0) {
                dst.write(buff, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /**
         * 보조 스트림
         * Node에 직접 연결되지 않고, 스트림에 부가적으로 사용되는 스트림
         * 보조 스트림을 연쇄적으로 생성 가능 -> Stream Chaining
         *
         * InputStreamReader ┬ byte 스트림 -> char 스트림
         * OuputStreamWriter ┘
         *
         * 반응성이 중요하지 않은 경우 (파일입출력, 네트워크 일부 경우(다운로드, 업로드...) 등등)
         * BufferedReader       ┬ 스트림에 버퍼링 적용하여 스트림 throughput 향상
         * BufferedWriter       ┤  throughput: 평균 전송 속도
         * BufferedInputStream  ┤  delay: 버퍼링을 쓸 경우 오히려 안좋아짐
         * BufferedOutputStream ┘
         *
         */
        /*
        //todo 정확히 어떻게 된거지?
        File src = new File("C:/Windows/explorer.exe");
        File dst = new File("C:/Users/deHong/Documents/workspace/Temp/MyTemp/explore.exe");

        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dst);
             BufferedInputStream buffIn = new BufferedInputStream(in);
             BufferedOutputStream buffOut = new BufferedOutputStream(out);) {
            long start = System.nanoTime();
            copyStream(in, out);
            System.out.println(System.nanoTime() - start); // 89161900

            start = System.nanoTime();
            copyStream(buffIn, buffOut);
            System.out.println(System.nanoTime() - start); // 24300
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /**
         * DataInputStream   ┬ 기본형 데이터 (Primitive Type)을 전송하기 위한 스트림
         * DataOutputStream  ┘   Stream, Reader(Writer)는 byte/char
         *                       readBoolean, readByte, readShort ... readUTF(String)
         *                       writeBoolean, writeByte, writeShort ... writeUTF(String
         */
        /*
        File src = new File("C:/Users/deHong/Documents/workspace/Temp/MyTemp/data.dat");
        DataOutputStream out = new DataOutputStream(new FileOutputStream(src));
        out.writeUTF("Java King");
        out.writeInt(128);
        out.writeFloat(511.511f);

        DataInputStream in = new DataInputStream(new FileInputStream(src));
        String str = in.readUTF();
        int integer = in.readInt();
        float floatVal = in.readFloat();

        System.out.println(str + " " + integer + " " + floatVal); // Java King 128 511.511
        */

        // 객체 직렬화를 위한 인터페이스 - Serializable
        class Foo implements Serializable {
            // 클래스 버전 관리
            // 객체를 저장할때와 불러올 때 같은지 체크하여 serialVersionUID가 일치하지 않으면 실패
            static final long serialVersionUID = 1L;


            // Serialize에 포함하지 않음(저장/불러오기 대상에서 제외)
            String userName;
            int userID;
            transient String password;

            public Foo() {
            }

            public Foo(String userName, int userID, String password) {
                this.userName = userName;
                this.userID = userID;
                this.password = password;
            }

            @Override
            public String toString() {
                return userName + " " + userID + " " + password;
            }
        }
         Foo foo = new Foo("Hansol-The-Outsider",
            1423, "negazeilzalnaga");
        System.out.println(foo); // Hansol-The-Outsider 1423 negazeilzalnaga

        File dst = new File("C:/Users/deHong/Documents/workspace/Temp/MyTemp/obj.data");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dst));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(dst))) {
            out.writeObject(foo);
            Object read = in.readObject();
            if (read != null && read instanceof Foo) {
                Foo readFoo = (Foo)read;
                System.out.println(readFoo); // Hansol-The-Outsider 1423 null
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 부모클래스는 Serializable 하지 않을 때, 자식 클래스를 Serializable하게 구현하기
        class ParentFoo {
            int memVarOne;
            double memVarTwo;
        }

        class ChildFoo extends ParentFoo implements  Serializable {
            int childMember;

            private void writeObject(ObjectOutputStream out) throws IOException {
                out.writeInt(memVarOne);
                // out.writeDouble(memVarTwo); // transient 대신 그냥 원하는것만 쓰면 됨.
                out.defaultWriteObject();
            }

            private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
                memVarOne = in.readInt();
//                memVarTwo = in.readDouble();
                in.defaultReadObject();
            }

        }

    }
}
