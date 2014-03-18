
package javaapplication1;

import java.io.IOException;
import java.util.Scanner;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.packet.Packet;

/**
 *
 * @author arthurfernandes
 */
public class Sniffer{
    public static void main(String args[]) throws IOException{
        //Obter a lista de interfaces
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        
        for (int i = 0; i < devices.length; i++) {
          //Imprimir o nome a descricao da interface
          System.out.println(i+": "+devices[i].name + "(" + devices[i].description+")");

          //Imprimir a descricao do enlace
          System.out.println(" datalink: "+devices[i].datalink_name + "(" + devices[i].datalink_description+")");

          //Imprima o endereco Mac da Interface
          System.out.print(" MAC address:");
          for (byte b : devices[i].mac_address)
            System.out.print(Integer.toHexString(b&0xff) + ":");
          System.out.println();

          //Imprimir o endereco IP, mascara de subrede e broadcast
          for (NetworkInterfaceAddress a : devices[i].addresses)
            System.out.println(" address:"+a.address + " " + a.subnet + " "+ a.broadcast);
        }

        System.out.println("Entre com o numero da interface que deseja se conectar:");
        
        Scanner networkInterfaceToConnect = new Scanner(System.in);
        int index = networkInterfaceToConnect.nextInt(); 
        JpcapCaptor captor=JpcapCaptor.openDevice(devices[index], 65535, false, 20);
        
        //Coloque um filtro para trabalhar com ip e tcp apenas
        
        captor.setFilter("ip and tcp ", true);
        
        while(true){
            //Capture um pacote e imprima na tela. 
            Packet p = captor.getPacket();
            
            if(p!=null){
                System.out.println(p);
            }
        }
        
    }
    
    
}
