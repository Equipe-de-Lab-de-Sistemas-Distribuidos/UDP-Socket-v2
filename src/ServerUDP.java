import java.net.*;
import org.jasypt.util.text.BasicTextEncryptor;

class ServerUDP {
	public static void main(String args[]) throws Exception {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();     
        	textEncryptor.setPassword("senha");

		int porta = Integer.parseInt(args[0]);
		
		try (DatagramSocket serverSocket = new DatagramSocket(porta)) {
			byte[] receiveData;
			byte[] sendData;
			while (true) {
				receiveData = new byte[1024];
				sendData = new byte[1024];

				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				System.out.println("Esperando por datagrama UDP na porta " + porta);
				serverSocket.receive(receivePacket);
				System.out.print("Datagrama UDP recebido...");

				String sentence = new String(receivePacket.getData());
				System.out.println("Msg recebida do cliente " + sentence);

				InetAddress IPAddress = receivePacket.getAddress();

				int port = receivePacket.getPort();

				String encryptedText = textEncryptor.encrypt(sentence);
				System.out.println("Texto Criptografado: "+encryptedText);

				sendData = encryptedText.getBytes();

				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

				System.out.print("Enviando " + sendData + "...");

				serverSocket.send(sendPacket);
				System.out.println("OK\n");
			    }
		}
	}
}
