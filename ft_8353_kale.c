/**
 * ============================================================================
 * PROJE ADI  : FT 8353 KALE
 * PROJE AMACI: Güvenli Blok Veri İşleme, Kriptografik Karma ve Doğrulama Sistemi
 *              (Secure Block Data Processing, Cryptographic Hashing & Verification)
 * AÇIKLAMA   : Bu C programı, 1069 baytlık asal blok boyutları (BLOCK_SIZE) ve
 *              8353 gizli parametresi (SECRET_PARAMETER) ile yüksek seviyeli
 *              veri bloklarını işleme, doğrulama ve kale savunma mekanizmalı 
 *              kriptografik simülasyonunu gerçekleştirmek amacıyla tasarlanmıştır.
 * YAZAR      : FT 8353 KALE Geliştirici Ekibi
 * TARİH      : 2026-06-18
 * ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* Blok boyutu (Asal Sayı) */
#define BLOCK_SIZE 1069

/* Gizli Güvenlik Parametresi */
#define SECRET_PARAMETER 8353

/**
 * Chaos Mixer matrisini baslatan fonksiyon.
 * 1069x1069 boyutundaki matrisi SECRET_PARAMETER (8353) tohumu ile
 * rastgele degerlerle doldurur.
 */
void ft8353_init_mixer(unsigned char matrix[BLOCK_SIZE][BLOCK_SIZE]) {
    srand(SECRET_PARAMETER);
    for (int i = 0; i < BLOCK_SIZE; i++) {
        for (int j = 0; j < BLOCK_SIZE; j++) {
            matrix[i][j] = (unsigned char)(rand() % 256);
        }
    }
    printf("[OK] Chaos Mixer matrisi oluşturuldu\n");
}

/**
 * Chaos Mixer fonksiyonu.
 * Data içerisindeki her bir baytı, matrisin matrix[i][i % 1069] değeriyle XOR
 * işlemine sokarak veriyi karıştırır (şifreleme/çözme).
 */
void chaos_mixer(unsigned char *data, unsigned char matrix[BLOCK_SIZE][BLOCK_SIZE]) {
    for (int i = 0; i < BLOCK_SIZE; i++) {
        data[i] ^= matrix[i][i % BLOCK_SIZE];
    }
}

/**
 * Bir veri bloğunu işleyen ve gizli parametre ile kriptografik
 * karıştırma (scrambling) işlemi yapan fonksiyon.
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
    // 1. static unsigned char kale_matrix[1069][1069] tanımla.
    static unsigned char kale_matrix[BLOCK_SIZE][BLOCK_SIZE];
    
    // 2. Örnek olarak 'BU COK ONEMLI BIR GIZLI METINDIR.' cümlesini içeren bir dizi oluştur.
    unsigned char test_metni[BLOCK_SIZE] = {0};
    const char *orijinal_cumle = "BU COK ONEMLI BIR GIZLI METINDIR.";
    int mesaj_uzunlugu = 0;
    
    // Mesaj uzunluğunu bulalım ve diziye kopyalayalım
    while (orijinal_cumle[mesaj_uzunlugu] != '\0' && mesaj_uzunlugu < BLOCK_SIZE) {
        test_metni[mesaj_uzunlugu] = (unsigned char)orijinal_cumle[mesaj_uzunlugu];
        mesaj_uzunlugu++;
    }
    
    printf("==================================================\n");
    printf("        FT 8353 KALE SIMETRIK CHAOS MIXER TEST    \n");
    printf("==================================================\n");
    printf("Orijinal Metin: %s\n\n", orijinal_cumle);
    
    // 3. Önce 'ft8353_init_mixer' fonksiyonunu çağırarak matrisi başlat.
    ft8353_init_mixer(kale_matrix);
    
    // 4. Sonra 'chaos_mixer' fonksiyonunu kullanarak metni şifrele.
    chaos_mixer(test_metni, kale_matrix);
    
    // 5. Şifrelenmiş halini ekrana HEX formatında yazdır.
    printf("Şifrelenmiş Metin (HEX): ");
    for (int i = 0; i < mesaj_uzunlugu; i++) {
        printf("%02X", test_metni[i]);
    }
    printf("\n\n");
    
    // 6. Ardından, aynı metni tekrar 'chaos_mixer' fonksiyonundan geçirerek (çözme işlemi)
    chaos_mixer(test_metni, kale_matrix);
    
    // 7. Orijinal halini ekrana yazdır.
    printf("Çözülmüş Orijinal Metin: ");
    for (int i = 0; i < mesaj_uzunlugu; i++) {
        printf("%c", test_metni[i]);
    }
    printf("\n\n");
    
    // 8. En sona 'Test Basariyla Tamamlandi' mesajını ekle.
    printf("Test Basariyla Tamamlandi\n");
    printf("==================================================\n");
    
    return 0;
}
