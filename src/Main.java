import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    static StringBuilder sb;

    public static void newDir(String[] dirs) {

        for (String name : dirs) {
            File dir = new File(name);
            if (dir.mkdir())
                sb.append(LocalDateTime.now() + " Каталог " + name + " создан \n");
            else
                sb.append(LocalDateTime.now() + "Не возможно создать каталог " + name + "\n");
        }

    }
    public static void newFile(String files[]) {

        for (String name : files) {
            File myFile = new File(name);
            try {
                if (myFile.createNewFile())
                    sb.append(LocalDateTime.now() + " Файл " + name +  " создан \n");

            } catch (IOException ex) {
                sb.append(LocalDateTime.now() + " Файл " + name + ex.getMessage() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        sb = new StringBuilder();

        String [] dirs =  {
                "Games/src",
                "Games/res",
                "Games/savegames",
                "Games/temp",
                "Games/src/main",
                "Games/src/test",
                "Games/res/drawables",
                "Games/res/vectors",
                "Games/res/icons",
        };
        newDir(dirs);
        String [] files =  {
                "Games/src/main/Main.java",
                "Games/src/main/Utils.java",
                "Games/temp/temp.txt",

        };
        newFile(files);

        try (FileWriter fw = new FileWriter("Games/temp/temp.txt")) {
            String log = sb.toString();
            fw.write(log);
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }






    }
}
