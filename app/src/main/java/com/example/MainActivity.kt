package com.example

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.CyberAccent
import com.example.ui.theme.CyberGold
import com.example.ui.theme.CyberGreen
import com.example.ui.theme.CyberGreenDark
import com.example.ui.theme.CyberSlate
import com.example.ui.theme.CyberSurface
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.SecureGrey
import com.example.ui.theme.TerminalBlack
import com.example.ui.theme.TextLight
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets.navigationBars
                ) { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(CyberSlate)
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

// C Program Code representation
val FT_8353_KALE_C_CODE = """/**
 * ============================================================================
 * PROJE ADI  : FT 8353 KALE
 * PROJE AMACI: Güvenli Blok Veri İşleme, Kriptografik Karma ve Doğrulama Sistemi
 *              (Secure Block Data Processing, Cryptographic Hashing & Verification)
 * AÇIKLAMA   : Bu C programı, 1069 baytlık asal blok boyutları (BLOCK_SIZE) ve
 *              8353 gizli parametresi (SECRET_PARAMETER) ile yüksek seviyeli
 *              veri bloklarını işleme, doğrulama ve kale savunma mekanizmalı 
 *              kriptografik simülasyonunu gerçekleştirmek amacıyla tasarlanmıştır.
 * YAZAR      : FT 8353 KALE Geliştirici Ekibi
 * TARİH      : 2026-06-22
 * ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

/* Blok boyutu (Asal Sayı) */
#define BLOCK_SIZE 1069

/* Gizli Güvenlik Parametresi */
#define SECRET_PARAMETER 8353

/**
 * Master anahtarı ve SECRET_PARAMETER (8353) değerini birleştirerek
 * dinamik bir şifreleme anahtarı (seed) üreten tek-yönlü fonksiyon.
 */
unsigned int derive_key(const char *master_key) {
    unsigned int hash = SECRET_PARAMETER;
    size_t i = 0;
    while (master_key[i] != '\0') {
        // DJB2 tabanlı dinamik karıştırma
        hash = ((hash << 5) + hash) + (unsigned char)master_key[i];
        i++;
    }
    return hash;
}

/**
 * Header (Başlık) bloğunu, alıcı ile anlaşılan 'Erişim Parolası'
 * ile şifreleyen ya da geri çözen simetrik kriptolama fonksiyonu.
 */
void encrypt_decrypt_header(unsigned char *header, const char *access_password) {
    unsigned int h_seed = derive_key(access_password);
    srand(h_seed);
    for (int i = 0; i < BLOCK_SIZE; i++) {
        header[i] ^= (unsigned char)(rand() % 256);
    }
}

/**
 * Chaos Mixer matrisini başlatan fonksiyon.
 * 1069x1069 boyutundaki matrisi dinamik dynamic_seed (derive_key çıktısı) ile
 * deterministik ve pseudo-random değerlerle doldurur.
 */
void ft8353_init_mixer(unsigned char matrix[BLOCK_SIZE][BLOCK_SIZE], unsigned int dynamic_seed) {
    srand(dynamic_seed);
    for (int i = 0; i < BLOCK_SIZE; i++) {
        for (int j = 0; j < BLOCK_SIZE; j++) {
            matrix[i][j] = (unsigned char)(rand() % 256);
        }
    }
    printf("[OK] Chaos Mixer matrisi dinamik Seed (%u) ile olusturuldu.\\n", dynamic_seed);
}

/**
 * Chaos Mixer fonksiyonu.
 * Veri bloğunun içerisindeki her bir baytı, anahtarla oluşturulan matrisin
 * ilgili index değerleriyle XOR işlemine sokarak çift yönlü karıştırır.
 */
void chaos_mixer(unsigned char *data, unsigned char matrix[BLOCK_SIZE][BLOCK_SIZE]) {
    for (int i = 0; i < BLOCK_SIZE; i++) {
        data[i] ^= matrix[i][i % BLOCK_SIZE];
    }
}

/**
 * 1069 baytlık blokların kendi içerisindeki bayt sıralamasını
 * SECRET_PARAMETER (8353) sabitine dayalı deterministik olarak karıştırır (encrypt) veya geri çözer (decrypt).
 * Fisher-Yates shuffle algoritmasının ters çevrilebilir simetrik uyarlamasıdır.
 */
void block_shuffler(unsigned char *block, int encrypt) {
    srand(SECRET_PARAMETER);
    int swaps[BLOCK_SIZE];
    for (int i = BLOCK_SIZE - 1; i > 0; i--) {
        swaps[i] = rand() % (i + 1);
    }
    
    if (encrypt) {
        // İleri yönlü karıştırma (Fisher-Yates)
        for (int i = BLOCK_SIZE - 1; i > 0; i--) {
            int j = swaps[i];
            unsigned char temp = block[i];
            block[i] = block[j];
            block[j] = temp;
        }
    } else {
        // Geri yönlü / Tersine çözümleme (Swaps sırasının tam tersi yönde uygulanması)
        for (int i = 1; i < BLOCK_SIZE; i++) {
            int j = swaps[i];
            unsigned char temp = block[i];
            block[i] = block[j];
            block[j] = temp;
        }
    }
}

/**
 * Bir veri bloğunu işleyen ve gizli parametre ile kriptografik
 * karıştırma (scrambling) işlemi yapan bütünlük imza fonksiyonu.
 */
unsigned long long kale_blok_isleme(const unsigned char *blok, size_t uzunluk) {
    unsigned long long hash_degeri = SECRET_PARAMETER;
    
    for (size_t i = 0; i < uzunluk; i++) {
        // Blok karıştırma adımları (Fletcher-benzeri modüler akış)
        hash_degeri = ((hash_degeri ^ blok[i]) * 31) + SECRET_PARAMETER;
        hash_degeri = (hash_degeri << 5) | (hash_degeri >> (64 - 5)); // Döndürme
        hash_degeri ^= (i * 1069);
    }
    
    return hash_degeri;
}

int main() {
    // Chaos Mixer Matrisini İlklendirme (Statik alan kullanarak stack taşması önlenir)
    static unsigned char chaos_matrix[BLOCK_SIZE][BLOCK_SIZE];

    int secim;
    char girdi_ad[256];
    char cikti_ad[256];
    char master_key[256];
    char access_password[256];

    while (1) {
        printf("\\n===========================================\\n");
        printf("      KALE - FT 8353 Security System       \\n");
        printf("===========================================\\n");
        printf("1- Dosya Sifrele\\n");
        printf("2- Dosya Coz\\n");
        printf("3- Cikis\\n");
        printf("Seciminiz: ");
        
        if (scanf("%d", &secim) != 1) {
            printf("[HATA] Gecersiz giris yaptiniz!\\n");
            // Girdi tamponunu argümanlardan temizle (Sonsuz döngüyü önler)
            while (getchar() != '\\n');
            continue;
        }

        if (secim == 3) {
            printf("FT 8353 Security System kapatiliyor. Guvenli gunler dileriz!\\n");
            break;
        }

        if (secim == 1) {
            printf("Sifrelenecek dosya adini girin (orn: belge.txt): ");
            scanf("%s", girdi_ad);
            printf("Master Anahtari girin (orn: kale123): ");
            scanf("%s", master_key);
            printf("Erisim Parolasini girin (orn: giris456): ");
            scanf("%s", access_password);

            FILE *f_in = fopen(girdi_ad, "rb");
            if (f_in == NULL) {
                printf("[HATA] Girdi dosyasi (%s) acilamadi! Dosyanin mevcut oldugundan emin olun.\\n", girdi_ad);
                continue;
            }

            FILE *f_out = fopen("sifreli.kale", "wb+");
            if (f_out == NULL) {
                printf("[HATA] Cikti dosyasi (sifreli.kale) olusturulamadi!\\n");
                fclose(f_in);
                continue;
            }

            // Dosya başına 1069 baytlık placeholder bir Header bloğu hazırlayıp yaz
            unsigned char header_block[BLOCK_SIZE];
            memset(header_block, 0, BLOCK_SIZE);
            if (fwrite(header_block, 1, BLOCK_SIZE, f_out) != BLOCK_SIZE) {
                printf("[CRITICAL-HATA] Baslik taslagi dosyaya yazilamadi!\\n");
                fclose(f_in);
                fclose(f_out);
                continue;
            }

            // Master anahtardan tohum türet ve Chaos Mixer'ı ilklendir
            unsigned int dynamic_seed = derive_key(master_key);
            printf("[BILGI] Master anahtar turetildi (Seed: %u)\\n", dynamic_seed);
            ft8353_init_mixer(chaos_matrix, dynamic_seed);

            unsigned char buffer[BLOCK_SIZE];
            size_t okunana_bayt = 0;
            int blok_sayisi = 0;
            long long checksum = 0; // Dosya şifresiz bütünlük denetimi

            printf("[SISTEM] Dosya okuma ve sifreleme islemi baslatiliyor...\\n");

            // fread ile dosya içeriğini BLOCK_SIZE parçaları şeklinde oku
            while ((okunana_bayt = fread(buffer, 1, BLOCK_SIZE, f_in)) > 0) {
                blok_sayisi++;
                printf("[BLOK %d] %zu bayt %s dosyasindan basariyla okundu.\\n", blok_sayisi, okunana_bayt, girdi_ad);

                // Gerekirse Padding doldur (Blok boyutunu 1069'a tamamla)
                if (okunana_bayt < BLOCK_SIZE) {
                    printf("[SIMULASYON] Son blok %zu bayt ile yetersiz; %d bayta sifir dolgusuyla (Padding) tamamlanıyor...\\n", okunana_bayt, BLOCK_SIZE);
                    memset(buffer + okunana_bayt, 0, BLOCK_SIZE - okunana_bayt);
                }

                // Checksum hesaplaması (Orijinal verinin bütünlüğü için, padding dahil)
                for (int i = 0; i < BLOCK_SIZE; i++) {
                    checksum += buffer[i];
                }

                // Son bir güvenlik katmanı: block_shuffler ile blok içi bayt karıştırma
                printf("[ISLEME] %d. Blok 8353 parametreli block_shuffler ile karistiriliyor...\\n", blok_sayisi);
                block_shuffler(buffer, 1);

                // chaos_mixer fonksiyonundan geçirerek şifreleme
                printf("[ISLEME] %d. Blok Chaos Mixer matrisi kullanılarak sifreleniyor...\\n", blok_sayisi);
                chaos_mixer(buffer, chaos_matrix);

                // Şifrelenmiş bloğu KALE imza fonksiyonu ile işleme (Doğrulama imzası)
                unsigned long long sonuc_imzasi = kale_blok_isleme(buffer, BLOCK_SIZE);
                printf("[BILGI] Hesaplanan %d. Blok KALE Imzasi: 0x%016llX\\n", blok_sayisi, sonuc_imzasi);

                // Şifrelenmiş bloğu çıktı dosyasına yazdır
                size_t yazilan_bayt = fwrite(buffer, 1, BLOCK_SIZE, f_out);
                if (yazilan_bayt < BLOCK_SIZE) {
                    printf("[CRITICAL-HATA] Dosyaya yazma hatasi gerceklesti! Yazilan: %zu/%d bayt\\n", yazilan_bayt, BLOCK_SIZE);
                    break;
                }

                if (ferror(f_in) || ferror(f_out)) {
                    printf("[CRITICAL-HATA] Giriş veya çıkış akışında okuma/yazma hatası oluştu!\\n");
                    break;
                }
            }

            // Header bilgisine 'KALE' imzası, checksum ve orijinal master_key ekle
            header_block[0] = 'K';
            header_block[1] = 'A';
            header_block[2] = 'L';
            header_block[3] = 'E';
            *(long long *)(header_block + 8) = checksum;
            snprintf((char *)(header_block + 16), 256, "%s", master_key);

            // Header bloğunu alıcının bileceği Erişim Parolası ile şifrele
            encrypt_decrypt_header(header_block, access_password);

            // Dosyanın en başına dönüp bu şifreli başlığı placeholder'ın üstüne yaz
            if (fseek(f_out, 0, SEEK_SET) == 0) {
                fwrite(header_block, 1, BLOCK_SIZE, f_out);
            } else {
                printf("[CRITICAL-HATA] Sifreli baslik dosyaya gomulemedi! (fseek hatasi)\\n");
            }

            fclose(f_in);
            fclose(f_out);
            printf("[TAMAM] Dosyalar basariyla kapatildi (fclose).\\n");
            printf("[TAMAM] Toplam islenen ve sifrelenen veri blok sayisi: %d\\n", blok_sayisi);
            printf("[TAMAM] Sifreli dosya diske kaydedildi (Baslik Blogu dahil edilmistir): 'sifreli.kale'\\n");

        } else if (secim == 2) {
            printf("Cozulecek dosya adini girin (orn: sifreli.kale): ");
            scanf("%s", girdi_ad);
            printf("Cikis dosyasinin adini girin (orn: cozulmus.txt): ");
            scanf("%s", cikti_ad);
            printf("Erisim Parolasini girin (orn: giris456): ");
            scanf("%s", access_password);

            FILE *f_dec = fopen(girdi_ad, "rb");
            if (f_dec == NULL) {
                printf("[HATA] %s dosyasi acilamadi! Dosyanin mevcut oldugundan emin olun.\\n", girdi_ad);
                continue;
            }

            // Dosya boyutu tespiti
            if (fseek(f_dec, 0, SEEK_END) != 0) {
                printf("[HATA] Dosya sonuna konumlanilamadi!\\n");
                fclose(f_dec);
                continue;
            }
            long file_size = ftell(f_dec);
            if (fseek(f_dec, 0, SEEK_SET) != 0) {
                printf("[HATA] Dosya basina konumlanilamadi!\\n");
                fclose(f_dec);
                continue;
            }

            if (file_size < BLOCK_SIZE) {
                printf("[HATA] Dosya boyutu baslik kontrolu icin yetersiz!\\n");
                fclose(f_dec);
                continue;
            }

            // Başlık bloğunu oku
            unsigned char header_block[BLOCK_SIZE];
            if (fread(header_block, 1, BLOCK_SIZE, f_dec) != BLOCK_SIZE) {
                printf("[HATA] Baslik blogu okunamadi!\\n");
                fclose(f_dec);
                continue;
            }

            // Başlık bloğunu girilen erişim parolası ile çöz
            encrypt_decrypt_header(header_block, access_password);

            // Başlık imzası doğrulaması
            if (header_block[0] != 'K' || header_block[1] != 'A' || header_block[2] != 'L' || header_block[3] != 'E') {
                printf("[CRITICAL-HATA] Erisim Parolasi gecersiz veya dosya basligi bozulmus!\\n");
                fclose(f_dec);
                continue;
            }

            long long okunan_header_checksum = *(long long *)(header_block + 8);
            char extracted_master_key[256];
            snprintf(extracted_master_key, 256, "%s", (char *)(header_block + 16));

            printf("[BASARILI] Baslik blogu acildi! (Uyumlu 'KALE' imzasi bulundu)\\n");
            printf("[BILGI] Ayiklanan Master Anahtar: %s\\n", extracted_master_key);

            FILE *f_out_dec = fopen(cikti_ad, "wb");
            if (f_out_dec == NULL) {
                printf("[HATA] Cozulmus cikti dosyasi olusturulamadi!\\n");
                fclose(f_dec);
                continue;
            }

            // Master anahtardan tohum türet ve Chaos Mixer'ı ilklendir
            unsigned int dynamic_seed = derive_key(extracted_master_key);
            ft8353_init_mixer(chaos_matrix, dynamic_seed);

            unsigned char buffer[BLOCK_SIZE];
            long long cozulmus_checksum = 0;
            size_t toplam_okunan = 0;
            long data_size = file_size - BLOCK_SIZE;

            printf("[SISTEM] Sifreli dosya okunuyor ve simetrik olarak geri cozuluyor...\\n");

            while (toplam_okunan < (size_t)data_size) {
                size_t okunacak_boyut = (data_size - toplam_okunan) < BLOCK_SIZE ? (data_size - toplam_okunan) : BLOCK_SIZE;
                size_t read_bytes = fread(buffer, 1, okunacak_boyut, f_dec);
                if (read_bytes == 0) break;
                toplam_okunan += read_bytes;

                // Chaos Mixer ile simetrik geri çöz (XOR simetriktir)
                chaos_mixer(buffer, chaos_matrix);

                // Son bir güvenlik katmanı: block_shuffler karıştırmasını tersine çevir
                block_shuffler(buffer, 0);

                // Çözülen orijinal verinin checksum'ını hesapla
                for (int i = 0; i < BLOCK_SIZE; i++) {
                    cozulmus_checksum += buffer[i];
                }

                // Geri çözülmüş veriyi çıktı dosyasına yazdır (padding hariç yazma veya tam blok yazma)
                size_t written = fwrite(buffer, 1, read_bytes, f_out_dec);
                if (written < read_bytes) {
                    printf("[CRITICAL-HATA] Çözülmüş veri dosyaya yazılırken hata oluştu!\\n");
                    break;
                }

                if (ferror(f_dec)) {
                    printf("[CRITICAL-HATA] Dosya cozulurken okuma hatasi algilandi!\\n");
                    break;
                }
            }

            fclose(f_dec);
            fclose(f_out_dec);

            printf("\\n[SONUCLAR]\\n");
            printf("-> Basliktan Alinan Checksum: %lld\\n", okunan_header_checksum);
            printf("-> Hesaplanan Checksum      : %lld\\n", cozulmus_checksum);

            if (cozulmus_checksum != okunan_header_checksum) {
                printf("🚨 UYARI: Dosya bozulmus, mudahale edilmis veya anahtarlar uyumsuz!\\n");
            } else {
                printf("✅ BASARILI: Butunluk dogrulandi. Dosya guvenli ve saglam!\\n");
            }
            printf("===========================================\\n");
        } else {
            printf("[UYARI] Gecersiz secim! Lutfen 1, 2 veya 3 degerlerinden birini girin.\\n");
        }
    }

    return 0;
}"""

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabTitles = listOf("KALE TERMİNALİ", "C KODU GÖSTERİCİ", "ANALİZ & PARAMETRE")

    Column(modifier = modifier) {
        // App Header / Hero Banner
        SecurityHeader()

        // Tab selection with cyber-styled indicator
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = CyberSurface,
            contentColor = CyberGreen,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                    color = CyberGreen,
                    height = 3.dp
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    modifier = Modifier
                        .height(52.dp)
                        .testTag("tab_$index"),
                    text = {
                        Text(
                            text = title,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 0.5.sp,
                            color = if (selectedTab == index) CyberGreen else SecureGrey
                        )
                    }
                )
            }
        }

        // Active Tab Screen Content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(CyberSlate)
        ) {
            when (selectedTab) {
                0 -> TerminalTabScreen()
                1 -> CodeViewerTabScreen()
                2 -> AnalysisTabScreen()
            }
        }

        // System Health status footer bar
        FooterStatusBar()
    }
}

@Composable
fun SecurityHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF020617), CyberSlate)
                )
            )
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(CyberGreen)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "FT 8353 KALE",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily.Monospace,
                        color = Color.White,
                        letterSpacing = 1.sp
                    )
                }
                Text(
                    text = "Asal Blok Tabanlı Güvenlik Motoru",
                    fontSize = 12.sp,
                    color = CyberAccent,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Monospace
                )
            }

            // Secure Shield Icon Badge
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(CyberSurface)
                    .border(1.dp, CyberGreen.copy(alpha = 0.5f), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Shield Guard",
                    tint = CyberGreen,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

// SIMULATION ENGINE KOTLIN CODE
fun simulateKaleStepHashing(input: String): ULong {
    var dummyHash = 8353UL
    val bytes = input.toByteArray(Charsets.UTF_8)
    for (i in bytes.indices) {
        dummyHash = ((dummyHash xor bytes[i].toULong()) * 31UL) + 8353UL
        dummyHash = (dummyHash shl 5) or (dummyHash shr (64 - 5))
        dummyHash = dummyHash xor (i.toULong() * 1069UL)
    }
    return dummyHash
}

@Composable
fun TerminalTabScreen() {
    val coroutineScope = rememberCoroutineScope()
    var rawInputText by remember { mutableStateOf("BU COK ONEMLI BIR GIZLI METINDIR.") }
    var masterKeyText by remember { mutableStateOf("KALE123") }
    var accessPasswordText by remember { mutableStateOf("GIRIS456") }
    var isRunningSimulation by remember { mutableStateOf(false) }
    var compileProgress by remember { mutableStateOf(0f) }
    val consoleLogs = remember { mutableStateListOf<String>() }
    val keyboardController = LocalSoftwareKeyboardController.current

    // Initialize with standard welcome messages
    LaunchedEffect(Unit) {
        if (consoleLogs.isEmpty()) {
            consoleLogs.add("root@FT_8353_KALE:~# gcc ft_8353_kale.c -o ft_8353_kale")
            consoleLogs.add("root@FT_8353_KALE:~# ./ft_8353_kale --status")
            consoleLogs.add("[SİSTEM] Kodu derlemek veya simüle etmek için aşağıdaki butonları kullanın.")
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // Interactive Sandbox Controller Card
            Card(
                colors = CardDefaults.cardColors(containerColor = CyberSurface),
                border = BorderStroke(1.dp, CyberGreen.copy(alpha = 0.3f)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "İNTERAKTİF SİMÜLASYON VERİSİ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = CyberGreen,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Girdiğiniz metin ve master şifre temel alınarak, 1069 baytlık asal bloklarla dinamik anahtar türetimli şifreleme simüle edilecektir.",
                        fontSize = 11.sp,
                        color = TextLight.copy(alpha = 0.8f),
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    OutlinedTextField(
                        value = rawInputText,
                        onValueChange = { if (it.length <= 150) rawInputText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("terminal_input"),
                        textStyle = TextStyle(fontFamily = FontFamily.Monospace, color = TextLight),
                        label = { Text("Simülasyon Metni (Maks 150 Karakter)", color = SecureGrey, fontSize = 12.sp) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = TextLight,
                            unfocusedTextColor = TextLight,
                            focusedBorderColor = CyberGreen,
                            unfocusedBorderColor = SecureGrey.copy(alpha = 0.5f),
                            focusedContainerColor = TerminalBlack,
                            unfocusedContainerColor = TerminalBlack
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = masterKeyText,
                        onValueChange = { if (it.length <= 32) masterKeyText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("terminal_key_input"),
                        textStyle = TextStyle(fontFamily = FontFamily.Monospace, color = TextLight),
                        label = { Text("Master Anahtar (Dinamik Seed Türetimi için)", color = SecureGrey, fontSize = 12.sp) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = TextLight,
                            unfocusedTextColor = TextLight,
                            focusedBorderColor = CyberGreen,
                            unfocusedBorderColor = SecureGrey.copy(alpha = 0.5f),
                            focusedContainerColor = TerminalBlack,
                            unfocusedContainerColor = TerminalBlack
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = accessPasswordText,
                        onValueChange = { if (it.length <= 32) accessPasswordText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("terminal_access_password_input"),
                        textStyle = TextStyle(fontFamily = FontFamily.Monospace, color = TextLight),
                        label = { Text("Erişim Parolası (Alıcı için Şifreli Başlık)", color = SecureGrey, fontSize = 12.sp) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = TextLight,
                            unfocusedTextColor = TextLight,
                            focusedBorderColor = CyberGreen,
                            unfocusedBorderColor = SecureGrey.copy(alpha = 0.5f),
                            focusedContainerColor = TerminalBlack,
                            unfocusedContainerColor = TerminalBlack
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // "COMPILE & RUN" simulating button
                        Button(
                            onClick = {
                                if (!isRunningSimulation) {
                                    coroutineScope.launch {
                                        isRunningSimulation = true
                                        keyboardController?.hide()
                                        consoleLogs.clear()
                                        consoleLogs.add("system@FT_8353_KALE:~# echo \"$rawInputText\" > girdi.txt")
                                        delay(200)
                                        consoleLogs.add("system@FT_8353_KALE:~# gcc ft_8353_kale.c -Wall -O3 -o ft_8353_kale")
                                        
                                        // Fake compile progress
                                        for (i in 1..5) {
                                            compileProgress = i / 5f
                                            delay(150)
                                        }
                                        consoleLogs.add("[DERLEYİCİ] Kod başarılı bir şekilde derlendi. (Süre: 320ms)")
                                        consoleLogs.add("system@FT_8353_KALE:~# ./ft_8353_kale")
                                        delay(300)
                                        
                                        // MENU GİRİŞİ
                                        consoleLogs.add("\n===========================================")
                                        consoleLogs.add("      KALE - FT 8353 Security System       ")
                                        consoleLogs.add("===========================================")
                                        consoleLogs.add("1- Dosya Sifrele")
                                        consoleLogs.add("2- Dosya Coz")
                                        consoleLogs.add("3- Cikis")
                                        delay(400)
                                        consoleLogs.add("Seciminiz: 1")
                                        delay(350)
                                        consoleLogs.add("Sifrelenecek dosya adini girin (orn: belge.txt): girdi.txt")
                                        delay(300)
                                        consoleLogs.add("Master Anahtari girin (orn: kale123): $masterKeyText")
                                        delay(300)
                                        consoleLogs.add("Erisim Parolasini girin (orn: giris456): $accessPasswordText")
                                        delay(300)
                                        
                                        // Master anahtardan tohum türetme simülasyonu (DJB2)
                                        var testSeed = 8353L
                                        for (ch in masterKeyText) {
                                            testSeed = ((testSeed shl 5) + testSeed) + ch.code.toLong()
                                            testSeed = testSeed and 0xFFFFFFFFL
                                        }
                                        
                                        consoleLogs.add("[SİSTEM] Dosyanın basına 1069 baytlık bos/placeholder bir Header blogu yazıldı.")
                                        delay(200)
                                        consoleLogs.add("[BİLGİ] Master anahtar türetildi (Seed: $testSeed)")
                                        delay(250)
                                        consoleLogs.add("[OK] Chaos Mixer matrisi dinamik Seed ($testSeed) ile olusturuldu")
                                        delay(250)
                                        
                                        val currentText = if (rawInputText.isEmpty()) "BU COK ONEMLI BIR GIZLI METINDIR." else rawInputText
                                        val textBytes = currentText.toByteArray(Charsets.UTF_8)
                                        val inputLen = textBytes.size
                                        
                                        consoleLogs.add("[SİSTEM] Dosya okuma ve sifreleme islemi baslatılıyor...")
                                        delay(300)
                                        consoleLogs.add("[BLOK 1] $inputLen bayt girdi.txt dosyasından başarıyla okundu.")
                                        
                                        val testMetniBuf = ByteArray(1069)
                                        for (idx in textBytes.indices) {
                                            if (idx < 1069) testMetniBuf[idx] = textBytes[idx]
                                        }
                                        
                                        if (inputLen < 1069) {
                                            consoleLogs.add("[SİMÜLASYON] Son blok $inputLen bayt ile yetersiz; 1069 bayta sıfır dolgusuyla (Padding) tamamlanıyor...")
                                            delay(350)
                                        }
                                        
                                        consoleLogs.add("[İŞLEME] 1. Blok 8353 parametreli block_shuffler ile karistiriliyor...")
                                        delay(350);
                                        consoleLogs.add("[İŞLEME] 1. Blok Chaos Mixer matrisi kullanılarak sifreleniyor...")
                                        delay(350)
                                        
                                        // Calculate signature on padded block
                                        var simulatedHash = 8353UL
                                        for (i in 0 until 1069) {
                                            simulatedHash = ((simulatedHash xor testMetniBuf[i].toUByte().toULong()) * 31UL) + 8353UL
                                            simulatedHash = (simulatedHash shl 5) or (simulatedHash shr (64 - 5))
                                            simulatedHash = simulatedHash xor (i.toULong() * 1069UL)
                                        }
                                        
                                        consoleLogs.add("[BİLGİ] Hesaplanan 1. Blok KALE İmzası: 0x%016X".format(simulatedHash.toLong()))
                                        delay(300)
                                        
                                        consoleLogs.add("[BİLGİ] Dosya sonuna (EOF) başarıyla ulaşıldı (feof kontrolü geçerli).")
                                        delay(200)
                                        
                                        var simulatedChecksum = 0L
                                        for (i in 0 until 1069) {
                                            simulatedChecksum += testMetniBuf[i].toUByte().toLong()
                                        }
                                        
                                        consoleLogs.add("[SİSTEM] Header bloguna 'KALE' imzası, checksum ($simulatedChecksum) ve master_key eklendi.")
                                        delay(250)
                                        consoleLogs.add("[İŞLEME] Header blogu alıcının erişim parolası ($accessPasswordText) ile şifrelendi (Header Seed türetimi).")
                                        delay(300)
                                        consoleLogs.add("[SİSTEM] Şifreli Header Bloğu dosyanın en basına (Seek 0) yazıldı.")
                                        delay(200)
                                        
                                        consoleLogs.add("[TAMAM] Dosyalar başarıyla kapatıldı (fclose).")
                                        consoleLogs.add("[TAMAM] Toplam işlenen ve şifrelenen veri blok sayısı: 1")
                                        consoleLogs.add("[TAMAM] Sifreli dosya diske kaydedildi (Baslik Bloğu dahil edilmistir): 'sifreli.kale'")
                                        delay(600)
                                        
                                        // MENU TEKRAR - ÇÖZME İNCELEMESİ
                                        consoleLogs.add("\n===========================================")
                                        consoleLogs.add("      KALE - FT 8353 Security System       ")
                                        consoleLogs.add("===========================================")
                                        consoleLogs.add("1- Dosya Sifrele")
                                        consoleLogs.add("2- Dosya Coz")
                                        consoleLogs.add("3- Cikis")
                                        delay(400)
                                        consoleLogs.add("Seciminiz: 2")
                                        delay(350)
                                        consoleLogs.add("Cozulecek dosya adini girin (orn: sifreli.kale): sifreli.kale")
                                        delay(300)
                                        consoleLogs.add("Cikis dosyasinin adini girin (orn: cozulmus.txt): cozulmus.txt")
                                        delay(300)
                                        consoleLogs.add("Erisim Parolasini girin (orn: giris456): $accessPasswordText")
                                        delay(300)
                                        
                                        consoleLogs.add("[SİSTEM] Sifreli dosyanın ilk blogu (Header) basarıyla okundu.")
                                        delay(250)
                                        consoleLogs.add("[İŞLEME] Baslik blogu girilen erisim parolası ile cozuldu.")
                                        delay(200)
                                        consoleLogs.add("[BAŞARILI] Baslik blogu acildi! (Uyumlu 'KALE' imzası bulundu)")
                                        delay(200)
                                        consoleLogs.add("[BİLGİ] Ayıklanan Master Anahtar: $masterKeyText")
                                        delay(200)
                                        
                                        consoleLogs.add("[BİLGİ] Master anahtar türetildi (Seed: $testSeed)")
                                        delay(250)
                                        consoleLogs.add("[OK] Chaos Mixer matrisi dinamik Seed ($testSeed) ile olusturuldu")
                                        delay(250)
                                        
                                        consoleLogs.add("[SİSTEM] Sifreli dosya okunuyor ve simetrik olarak geri çözülüyor...")
                                        delay(450)
                                        consoleLogs.add("[İŞLEME] 1. Blok Chaos Mixer matrisi kullanılarak geri çözülüyor...")
                                        delay(300)
                                        consoleLogs.add("[İŞLEME] 1. Blok block_shuffler karıştırması tersine çevriliyor...")
                                        delay(300)
                                        consoleLogs.add("\n[SONUÇLAR]")
                                        consoleLogs.add("-> Basliktan Alinan Checksum: $simulatedChecksum")
                                        consoleLogs.add("-> Hesaplanan Checksum      : $simulatedChecksum")
                                        delay(300)
                                        consoleLogs.add("✅ BAŞARILI: Bütünlük doğrulandı. Dosya güvenli ve sağlam!")
                                        delay(600)
                                        
                                        // MENU TEKRAR - ÇIKIŞ İNCELEMESİ
                                        consoleLogs.add("\n===========================================")
                                        consoleLogs.add("      KALE - FT 8353 Security System       ")
                                        consoleLogs.add("===========================================")
                                        consoleLogs.add("1- Dosya Sifrele")
                                        consoleLogs.add("2- Dosya Coz")
                                        consoleLogs.add("3- Cikis")
                                        delay(400)
                                        consoleLogs.add("Seciminiz: 3")
                                        delay(350)
                                        consoleLogs.add("FT 8353 Security System kapatiliyor. Guvenli gunler dileriz!")
                                        
                                        compileProgress = 0f
                                        isRunningSimulation = false
                                    }
                                }
                            },
                            enabled = !isRunningSimulation,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = CyberGreen,
                                contentColor = Color.Black,
                                disabledContainerColor = CyberGreen.copy(alpha = 0.3f),
                                disabledContentColor = SecureGrey
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .testTag("run_button_c"),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Run Icon",
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("C YAZILIMINI ÇALIŞTIR", fontSize = 11.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
                        }

                        // Code analysis reset
                        Button(
                            onClick = {
                                rawInputText = "KALE SAVUNMA SİSTEMİ 8353"
                                consoleLogs.clear()
                                consoleLogs.add("root@FT_8353_KALE:~# clear")
                                consoleLogs.add("[SİSTEM] Terminal temizlendi. Yeniden çalıştırmak için butona basın.")
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = CyberSurface,
                                contentColor = CyberAccent
                            ),
                            border = BorderStroke(1.dp, CyberAccent.copy(alpha = 0.5f)),
                            modifier = Modifier
                                .height(48.dp)
                                .testTag("reset_button_c"),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Temizle",
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    if (isRunningSimulation) {
                        Spacer(modifier = Modifier.height(12.dp))
                        LinearProgressIndicator(
                            progress = { compileProgress },
                            modifier = Modifier.fillMaxWidth(),
                            color = CyberGreen,
                            trackColor = TerminalBlack
                        )
                    }
                }
            }
        }

        item {
            // Interactive Tower Block visualizer
            InteractiveBlockGrid(rawInputText)
        }

        item {
            // Linux Terminal Box Output
            Text(
                text = "C PROGRAMI STDOUT ÇIKTISI (TERMİNAL)",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = CyberAccent,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            )

            Card(
                colors = CardDefaults.cardColors(containerColor = TerminalBlack),
                border = BorderStroke(1.dp, CyberAccent.copy(alpha = 0.3f)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(12.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(consoleLogs) { log ->
                        val color = when {
                            log.startsWith("system") || log.startsWith("root") -> CyberAccent
                            log.startsWith("->") || log.contains("SONUÇLARI") -> CyberGreen
                            log.contains("[BİLGİ]") -> CyberGold
                            log.contains("[GÜVENLİ]") -> CyberGreen
                            log.contains("[SİMÜLASYON]") -> TextLight.copy(alpha = 0.7f)
                            else -> TextLight
                        }
                        Text(
                            text = log,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            color = color,
                            lineHeight = 16.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InteractiveBlockGrid(inputText: String) {
    val totalSize = 1069
    val inputBytesSize = inputText.toByteArray(Charsets.UTF_8).size
    val filledPercent = (inputBytesSize.toFloat() / totalSize) * 100

    Card(
        colors = CardDefaults.cardColors(containerColor = CyberSurface),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, CyberAccent.copy(alpha = 0.2f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "KALE BLOK BELLEK MATRİSİ",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = CyberAccent,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "BLOCK_SIZE = $totalSize Bayt (Asal Modül Sınırı)",
                fontSize = 11.sp,
                color = SecureGrey,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Memory usage mini-bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dolu Bölüm (Veri): $inputBytesSize/1069 Bayt (%.2f%%)".format(filledPercent),
                    fontSize = 11.sp,
                    color = TextLight,
                    fontFamily = FontFamily.Monospace
                )
                Text(
                    text = "Boş Bölüm (Padding): ${totalSize - inputBytesSize} Bayt",
                    fontSize = 11.sp,
                    color = SecureGrey,
                    fontFamily = FontFamily.Monospace
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Progress outline block
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(TerminalBlack)
                    .border(1.dp, SecureGrey.copy(alpha = 0.3f), RoundedCornerShape(4.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(inputBytesSize.toFloat() / totalSize)
                        .height(20.dp)
                        .background(
                            Brush.linearGradient(
                                colors = listOf(CyberGreen, CyberAccent)
                            )
                        )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Representing physical memory blocks
            Text(
                text = "Blok Hücre Dağılımı ve Güvenlik Surları (Görsel Simüle)",
                fontSize = 11.sp,
                color = TextLight.copy(alpha = 0.7f),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Let's draw 32 sample nodes representing memory cells
            val cells = remember(inputText) {
                List(32) { index ->
                    val cellThreshold = (totalSize / 32f) * index
                    cellThreshold < inputBytesSize
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(8),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                userScrollEnabled = false
            ) {
                itemsIndexed(cells) { index, isFilled ->
                    val cellColor = if (isFilled) CyberGreen else CyberSurface
                    val cellBorder = if (isFilled) CyberGreen else SecureGrey.copy(alpha = 0.4f)
                    val labelColor = if (isFilled) Color.Black else SecureGrey

                    Box(
                        modifier = Modifier
                            .height(24.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(cellColor)
                            .border(1.dp, cellBorder, RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (isFilled) "D%02d".format(index) else "P%02d".format(index),
                            fontSize = 8.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            color = labelColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CodeViewerTabScreen() {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "ft_8353_kale.c",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = CyberGreen,
                    fontFamily = FontFamily.Monospace
                )
                Text(
                    text = "C Kütüphaneleri & Makro Konfigürasyonu",
                    fontSize = 11.sp,
                    color = SecureGrey,
                    fontFamily = FontFamily.Monospace
                )
            }

            // Copy source code button
            Button(
                onClick = {
                    clipboardManager.setText(AnnotatedString(FT_8353_KALE_C_CODE))
                    Toast.makeText(context, "FT 8353 KALE kodları panoya kopyalandı!", Toast.LENGTH_SHORT).show()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = CyberGreen.copy(alpha = 0.15f),
                    contentColor = CyberGreen
                ),
                border = BorderStroke(1.dp, CyberGreen.copy(alpha = 0.4f)),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                modifier = Modifier.testTag("copy_code_btn")
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Copy Icon",
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("KOPYALA", fontSize = 11.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
            }
        }

        // C Code Editor Display Area (Fully Scannable with Syntax Colors)
        Card(
            colors = CardDefaults.cardColors(containerColor = TerminalBlack),
            border = BorderStroke(1.dp, SecureGrey.copy(alpha = 0.3f)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                item {
                    Text(
                        text = buildAnnotatedCodeString(FT_8353_KALE_C_CODE),
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        lineHeight = 15.sp
                    )
                }
            }
        }
    }
}

// Fun parsing C code simple keywords to paint them in beautiful syntax colors!
fun buildAnnotatedCodeString(code: String): AnnotatedString {
    return buildAnnotatedString {
        val lines = code.split("\n")
        var inComment = false

        for (line in lines) {
            var tempLine = line
            
            // Check for multiline comments
            if (tempLine.trim().startsWith("/**") || tempLine.trim().startsWith("/*")) {
                inComment = true
                withStyle(style = SpanStyle(color = Color(0xFF10B981))) { // Comment Green
                    append(tempLine + "\n")
                }
                if (tempLine.contains("*/")) {
                    inComment = false
                }
                continue
            }
            if (inComment) {
                withStyle(style = SpanStyle(color = Color(0xFF10B981))) {
                    append(tempLine + "\n")
                }
                if (tempLine.contains("*/")) {
                    inComment = false
                }
                continue
            }

            // Normal line - highlight preprocessors, macros, and basic types
            if (tempLine.trim().startsWith("#")) {
                // Preprocessor like #include <stdio.h> or #define BLOCK_SIZE
                val words = tempLine.split(" ")
                val firstWord = words[0] // e.g. #include or #define
                withStyle(style = SpanStyle(color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold)) { // Blue
                    append(firstWord)
                }
                if (words.size > 1) {
                    append(" ")
                    val remaining = words.drop(1).joinToString(" ")
                    if (remaining.contains("<") && remaining.contains(">")) {
                        withStyle(style = SpanStyle(color = Color(0xFFF59E0B))) { // Amber for headers
                            append(remaining)
                        }
                    } else if (remaining.contains("BLOCK_SIZE") || remaining.contains("SECRET_PARAMETER")) {
                        val parts = remaining.split(" ")
                        val macroName = parts[0]
                        withStyle(style = SpanStyle(color = Color(0xFFF1F5F9), fontWeight = FontWeight.Bold)) {
                            append(macroName)
                        }
                        if (parts.size > 1) {
                            append(" ")
                            withStyle(style = SpanStyle(color = Color(0xFFF59E0B))) { // Gold values
                                append(parts.drop(1).joinToString(" "))
                            }
                        }
                    } else {
                        append(remaining)
                    }
                }
                append("\n")
            } else {
                // General line of C code
                val parts = tempLine.split(" ")
                parts.forEachIndexed { i, word ->
                    val cleanWord = word.replace("(", "").replace(")", "").replace(";", "").replace("{", "").replace("}", "").trim()
                    when (cleanWord) {
                        "int", "void", "unsigned", "char", "unsigned long long", "unsigned char", "size_t", "const" -> {
                            withStyle(style = SpanStyle(color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold)) {
                                append(word)
                            }
                        }
                        "return", "for", "while", "if", "else" -> {
                            withStyle(style = SpanStyle(color = Color(0xFFEE82EE), fontWeight = FontWeight.SemiBold)) {
                                append(word)
                            }
                        }
                        "BLOCK_SIZE", "SECRET_PARAMETER" -> {
                            withStyle(style = SpanStyle(color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold)) {
                                append(word)
                            }
                        }
                        else -> {
                            if (word.startsWith("printf") || word.startsWith("srand") || word.startsWith("time") || word.startsWith("rand") || word.startsWith("kale_blok_isleme")) {
                                withStyle(style = SpanStyle(color = Color(0xFFF3F4F6))) {
                                    append(word)
                                }
                            } else {
                                append(word)
                            }
                        }
                    }
                    if (i < parts.size - 1) append(" ")
                }
                append("\n")
            }
        }
    }
}

@Composable
fun AnalysisTabScreen() {
    var checkNumberStr by remember { mutableStateOf("") }
    var primeResultText by remember { mutableStateOf("Bir sayı girip asallığını test edin.") }
    var isPrimeNumber by remember { mutableStateOf<Boolean?>(null) }
    val keyboardController = LocalSoftwareKeyboardController.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // Explainer Alert Banner
            Card(
                colors = CardDefaults.cardColors(containerColor = CyberSurface),
                border = BorderStroke(1.dp, CyberGold.copy(alpha = 0.4f)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Warning Info",
                        tint = CyberGold,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "KRİPTOGRAFİK PARAMETRE DEĞERLERİ",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = CyberGold,
                            fontFamily = FontFamily.Monospace
                        )
                        Text(
                            text = "Neden BLOCK_SIZE = 1069 ve SECRET_PARAMETER = 8353 seçildi? Bu sayılar sistem bütünlüğünü nasıl korur?",
                            fontSize = 11.sp,
                            color = TextLight,
                            lineHeight = 15.sp
                        )
                    }
                }
            }
        }

        item {
            // Detailed Parameter Explanation Cards
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                // Card 1: Block Size 1069
                Card(
                    colors = CardDefaults.cardColors(containerColor = CyberSurface),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(CyberGreen)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "BLOCK_SIZE = 1069 (Asal Sayı)",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = CyberGreen,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "C kodunda tanımlanan 1069 blok boyutu bir asal sayıdır. Asal sayı modülleri, çarpımsal karma (hash) işlemlerinde verilerin eşit dağılmasını sağlayarak çakışmaları (hash collision) önler. Giriş verisinin periyotları ile modülün ortak böleninin bulunma riski sıfıra iner.",
                            fontSize = 11.sp,
                            color = TextLight.copy(alpha = 0.8f),
                            lineHeight = 15.sp
                        )
                    }
                }

                // Card 2: Secret Parameter 8353
                Card(
                    colors = CardDefaults.cardColors(containerColor = CyberSurface),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(CyberAccent)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "SECRET_PARAMETER = 8353",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = CyberAccent,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Sabit bir güvenlik parametresi olarak kullanılan 8353 değeri, karma fonksiyonunun başlangıç durumunu belirleyen (IV - Initialization Vector benzeri) tuzlama parametresidir. Dışarıdan veri manipülasyonu yapılsa dahi, bu değer bilinmeden imza taklit edilemez.",
                            fontSize = 11.sp,
                            color = TextLight.copy(alpha = 0.8f),
                            lineHeight = 15.sp
                        )
                    }
                }
            }
        }

        item {
            // Interactive Asallık Testi (Primality Checker Sandbox)
            Card(
                colors = CardDefaults.cardColors(containerColor = CyberSurface),
                border = BorderStroke(1.dp, CyberGreen.copy(alpha = 0.3f)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "MATEMATİK KANITI: ASALLIK DOĞRULAYICI",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = CyberGreen,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Bir sayının asal olup olmadığını kontrol edin ve 1069 sayısı ile ilişkisini inceleyin:",
                        fontSize = 11.sp,
                        color = TextLight.copy(alpha = 0.8f),
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    OutlinedTextField(
                        value = checkNumberStr,
                        onValueChange = { input ->
                            if (input.all { it.isDigit() } && input.length <= 9) checkNumberStr = input
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("prime_input"),
                        textStyle = TextStyle(fontFamily = FontFamily.Monospace, color = TextLight),
                        label = { Text("Asal Sınama Sayısı (Örn. 1069)", color = SecureGrey, fontSize = 12.sp) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = TextLight,
                            unfocusedTextColor = TextLight,
                            focusedBorderColor = CyberGreen,
                            unfocusedBorderColor = SecureGrey.copy(alpha = 0.5f)
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Search
                        ),
                        keyboardActions = KeyboardActions(
                            onSearch = {
                                keyboardController?.hide()
                                val num = checkNumberStr.toIntOrNull()
                                if (num == null) {
                                    primeResultText = "Lütfen geçerli bir tamsayı girin."
                                    isPrimeNumber = null
                                } else {
                                    val isPrime = isPrimeVal(num)
                                    isPrimeNumber = isPrime
                                    if (num == 1069) {
                                        primeResultText = "⚡ 1069 ASALDIR! FT 8353 KALE projesinin altın blok boyutudur. Kusursuz çarpan dağılımı sağlar."
                                    } else if (isPrime) {
                                        primeResultText = "✓ $num sayısı bir ASAL sayıdır! Güvenli blok veri işlemlerinde kullanılmaya uygundur."
                                    } else {
                                        primeResultText = "✗ $num asal değildir. $num = " + getFactorsStr(num) + " şeklinde çarpanlarına ayrılır. Güvenli modüller için kullanışlı değildir."
                                    }
                                }
                            }
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            keyboardController?.hide()
                            val num = checkNumberStr.toIntOrNull()
                            if (num == null) {
                                primeResultText = "Lütfen geçerli bir tamsayı girin."
                                isPrimeNumber = null
                            } else {
                                val isPrime = isPrimeVal(num)
                                isPrimeNumber = isPrime
                                if (num == 1069) {
                                    primeResultText = "⚡ 1069 ASALDIR! FT 8353 KALE projesinin temel blok boyutudur. Kusursuz hash çarpan dağılımı sağlar."
                                } else if (isPrime) {
                                    primeResultText = "✓ $num sayısı bir ASAL sayıdır! Güvenli blok veri işlemlerinde kullanılmaya uygundur."
                                } else {
                                    primeResultText = "✗ $num asal değildir. " + getFactorsStr(num) + " çarpanlarına ayrılır."
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = CyberGreen,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp)
                            .testTag("check_prime_btn"),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("ASALLIĞI DOĞRULA", fontSize = 11.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    AnimatedVisibility(
                        visible = primeResultText.isNotEmpty(),
                        enter = fadeIn() + slideInVertically(),
                        exit = fadeOut() + slideOutVertically()
                    ) {
                        val resultBoxColor = when (isPrimeNumber) {
                            true -> CyberGreen.copy(alpha = 0.1f)
                            false -> Color.Red.copy(alpha = 0.1f)
                            else -> TerminalBlack
                        }
                        val resultBorderColor = when (isPrimeNumber) {
                            true -> CyberGreen
                            false -> Color.Red
                            else -> SecureGrey.copy(alpha = 0.5f)
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(6.dp))
                                .background(resultBoxColor)
                                .border(1.dp, resultBorderColor, RoundedCornerShape(6.dp))
                                .padding(12.dp)
                        ) {
                            Text(
                                text = primeResultText,
                                fontSize = 12.sp,
                                color = TextLight,
                                fontFamily = FontFamily.Monospace,
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

// Math helpers
fun isPrimeVal(n: Int): Boolean {
    if (n <= 1) return false
    if (n <= 3) return true
    if (n % 2 == 0 || n % 3 == 0) return false
    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0) return false
        i += 6
    }
    return true
}

fun getFactorsStr(n: Int): String {
    if (n <= 1) return "1"
    var temp = n
    val factors = mutableListOf<String>()
    
    // Check 2s
    var d = 2
    while (temp % d == 0) {
        factors.add(d.toString())
        temp /= d
    }
    d = 3
    // Check odd divisors
    while (d * d <= temp) {
        while (temp % d == 0) {
            factors.add(d.toString())
            temp /= d
        }
        d += 2
    }
    if (temp > 1) {
        factors.add(temp.toString())
    }
    return factors.joinToString(" × ")
}

@Composable
fun FooterStatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(TerminalBlack)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(CyberGreen)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "KALE SAVUNMASI ETKİN",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = CyberGreen,
                fontFamily = FontFamily.Monospace
            )
        }

        Text(
            text = "YUKARIDAKİ BLOCK: 1069 | PARAM: 8353",
            fontSize = 10.sp,
            color = SecureGrey,
            fontFamily = FontFamily.Monospace
        )
    }
}
