import java.math.BigInteger;
import java.util.Random;

public class RSA {
    public BigInteger n;
    public BigInteger e;
    private BigInteger d;
    public RSA(int bits) {
        Random randomInteger = new Random();
        BigInteger p = BigInteger.probablePrime(bits, randomInteger);
        BigInteger q = BigInteger.probablePrime(bits, randomInteger);
        n = p.multiply(q);
        e = BigInteger.probablePrime(bits / 2, randomInteger);
        d = e.modInverse(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
    }

    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message).modPow(e, n)).toByteArray();
    }
    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(d, n).toByteArray();
    }
}
