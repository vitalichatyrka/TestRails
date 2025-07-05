package utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;

public class AllureUtils {

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        try {
            return Files.readAllBytes(Screenshots.takeScreenShotAsFile().toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
