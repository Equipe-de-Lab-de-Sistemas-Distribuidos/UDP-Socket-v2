import java.net.*;
import org.jasypt.util.text.BasicTextEncryptor;

class UDPServer {
	public static void main(String args[]) throws Exception {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();     
        textEncryptor.setPassword("1234");

		int porta = 9876;
		int numConn = 1;
		
		try (DatagramSocket serverSocket = new DatagramSocket(porta)) {
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];

			while (true) {

				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				System.out.println("Esperando por datagrama UDP na porta " + porta +" ...");
				serverSocket.receive(receivePacket);
				System.out.print("Datagrama UDP [" + numConn + "] recebido...");

				String sentence = new String(receivePacket.getData());
				System.out.println("Menssagem= "+sentence);
				
				InetAddress IPAddress = receivePacket.getAddress();

				int port = receivePacket.getPort();

                String encryptedText = textEncryptor.encrypt(sentence);
                System.out.println("TEXTO CRIPTOGRAFADO: "+encryptedText);

                sendData = encryptedText.getBytes();

				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

				System.out.print("Enviando " + sendData + "...");

				serverSocket.send(sendPacket);
				System.out.println("OK\n");
			}
		}
	}
}