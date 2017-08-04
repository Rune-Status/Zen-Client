import java.io.File;

interface Constants {

    String ADDRESS = "127.0.0.1";
    boolean ISAAC_ENABLED = false;
    boolean RSA_ENABLED = false;
    String HOME_DIRECTORY = System.getProperty("user.home") + File.separator;
    String CACHE_IDENTIFIER = "prodigy_cache";
    String WORKING_DIRECTORY = HOME_DIRECTORY + CACHE_IDENTIFIER;

}
