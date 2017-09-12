import com.sbt.javaschool.classloaders.Browser.Plugin;

/**
 * Класс имеет то же имя, что и классы в плагинах.
 * Необходимо изменить модель делегирования, чтобы загружались классы из плагинов, а не этот класс
 */
public class PluginClass implements Plugin {
    @Override
    public void printPluginName() {
        System.out.println("It's class PluginClass in Browser");
    }
}

