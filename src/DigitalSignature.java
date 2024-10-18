public class DigitalSignature {
    private final RSA rsa = new RSA(1024); // Класс RSA для управления ключами
    private final MD5 md5 = new MD5();
    /**
     * Создает цифровую подпись для переданного сообщения.
     * @param message Сообщение для подписи.
     * @return Подпись в виде байтового массива.
     */
    public byte[] signMessage(String message) {
        String messageHash = md5.getMD5(message);
        return rsa.encrypt(messageHash.getBytes());
    }

    /**
     * Проверяет подпись, используя переданное сообщение и цифровую подпись.
     * @param message Исходное сообщение.
     * @param signature Подпись для проверки.
     * @return true, если подпись верна, иначе false.
     */
    public boolean verifySignature(String message, byte[] signature) {
        MD5 md5 = new MD5();
        String messageHash = md5.getMD5(message);
        byte[] decryptedHash = rsa.decrypt(signature);
        return messageHash.equals(new String(decryptedHash));
    }
}
