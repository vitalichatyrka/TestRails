package api.adapters;

import utils.PropertyReader;

public class BaseAdapter {

  public static final String BASE_API_URL =
      System.getenv().getOrDefault("apiURL", PropertyReader.getProperty("apiURL"));
}
