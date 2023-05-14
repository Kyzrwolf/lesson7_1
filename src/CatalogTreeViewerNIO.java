import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


class CatalogTreeViewerNIO extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attr) throws IOException {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }

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
            Path path = Paths.get(targetPath);

        }
        try {
            Files.walkFileTree(Paths.get(targetPath), new CatalogTreeViewerNIO());
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}

