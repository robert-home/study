package pl.rbudner.study.sshd;

import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Server {

    private static final int SSHD_PORT = 22;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Key key = KeyPairGenerator.getInstance("DSA").generateKeyPair().getPrivate();
        new Server().start();
    }

    private void start() throws IOException {
        SshServer sshd = SshServer.setUpDefaultServer();
        File keyFile = new File("myKey.sha");
        sshd.setPort(SSHD_PORT);
        sshd.setPasswordAuthenticator((username, password, session) -> true);
        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(keyFile));

        sshd.start();

        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException ignored) { // nazwa zmiennej "ignored" usuwa warning
        } finally {
            //noinspection ThrowFromFinallyBlock
            sshd.stop();
        }

    }

}
