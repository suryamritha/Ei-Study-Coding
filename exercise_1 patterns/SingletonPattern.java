class ConfigManager {
    private static ConfigManager instance;
    private String config;

    private ConfigManager() {
        // Private constructor to restrict instantiation
        this.config = "Initial Config";
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        ConfigManager config1 = ConfigManager.getInstance();
        System.out.println(config1.getConfig());

        ConfigManager config2 = ConfigManager.getInstance();
        config2.setConfig("New Config");

        System.out.println(config1.getConfig()); // Reflects change in both config1 and config2
    }
}
