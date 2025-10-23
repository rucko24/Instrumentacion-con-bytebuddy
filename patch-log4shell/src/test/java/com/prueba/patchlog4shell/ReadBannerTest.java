package com.prueba.patchlog4shell;

import com.prueba.patchlog4shell.monkeybanner.ReadBanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ReadBannerTest {

    @Test
    @DisplayName("Read banner from resources :D")
    void readBanner() throws IOException {
        ReadBanner.showTheMonkey("banner.txt");
    }
}
