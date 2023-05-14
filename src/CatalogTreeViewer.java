import java.io.*;

public class CatalogTreeViewer {
   /* показывает насколько "глубоко" находится файл по отношению к переданному каталогу
    - в переданном каталоге
    -- на уровень ниже и т.д.*/
    static String counter = "-";

    public static void main(String[] args) {
        String targetPath;

        // проверки на передачу аргументов
      if (args.length == 0) {
          System.out.println("Использование: В аргументе командной строки указать путь к директории");
          System.out.println("Путь не задан. Будет использована текущая директория.");
          targetPath = System.getProperty("user.dir");
          System.out.println(targetPath);
      } else if (args[0].equals("")) {
          System.out.println("Передан пустой путь. Будет использована текущая директория");
          targetPath = System.getProperty("user.dir");
          System.out.println(targetPath);
      } else {
          targetPath = args[0];
          System.out.println(targetPath);
      }
        File dir = new File (String.valueOf(targetPath));
        printAllFilesFromDirectory(dir);

            }
   static void printAllFilesFromDirectory(File dir) {
       for (File file : dir.listFiles()) {
           print(file);
           if (file.isDirectory()) {
               counter += "-";
               printAllFilesFromDirectory(file);
           }
       }
       // рекурсивный обход директорий
      counter = counter.substring(0, counter.length() - 1);;
   }

   static void print(File file) {
       if (file.isDirectory()) {
           System.out.println(counter + " " + file.getName() + " каталог");
       } else {
           System.out.println(counter + " " + file.getName() + " файл");
       }

}
}
