package savemgo.nomad.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import savemgo.nomad.Util;
import savemgo.nomad.packet.Packet;

@Sharable
public class Lobby extends PacketHandler {

	public Lobby() {

	}

	@Override
	public boolean readPacket(ChannelHandlerContext ctx, Packet in) {
		int command = in.getCommand();

		switch (command) {

		/** General */
		case 0x0003:
			ctx.close();
			break;

		case 0x0005:
			ctx.write(new Packet(0x0005));
			break;

		/** Main Lobby */
		case 0x2005:
			ctx.write(new Packet(0x2002));

			byte rawData[] = {
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x20, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x4D, (byte)0x47, (byte)0x4F, (byte)0x32,
				(byte)0x2D, (byte)0x47, (byte)0x61, (byte)0x74, (byte)0x65, (byte)0x2D,
				(byte)0x4A, (byte)0x50, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
				(byte)0x31, (byte)0x39, (byte)0x32, (byte)0x2E, (byte)0x33, (byte)0x2E,
				(byte)0x32, (byte)0x31, (byte)0x37, (byte)0x2E, (byte)0x36, (byte)0x31,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x16, (byte)0x63, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x20, (byte)0x00, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x21, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
				(byte)0x4D, (byte)0x47, (byte)0x4F, (byte)0x32, (byte)0x2D, (byte)0x47,
				(byte)0x61, (byte)0x74, (byte)0x65, (byte)0x2D, (byte)0x55, (byte)0x53,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x31, (byte)0x39,
				(byte)0x32, (byte)0x2E, (byte)0x33, (byte)0x2E, (byte)0x32, (byte)0x31,
				(byte)0x37, (byte)0x2E, (byte)0x36, (byte)0x31, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x3D, (byte)0x73, (byte)0x00, (byte)0x00, (byte)0x00,
				(byte)0x21, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x22,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x4D, (byte)0x47,
				(byte)0x4F, (byte)0x32, (byte)0x2D, (byte)0x47, (byte)0x61, (byte)0x74,
				(byte)0x65, (byte)0x2D, (byte)0x45, (byte)0x55, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x31, (byte)0x39, (byte)0x32, (byte)0x2E,
				(byte)0x33, (byte)0x2E, (byte)0x32, (byte)0x31, (byte)0x37, (byte)0x2E,
				(byte)0x36, (byte)0x31, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x64,
				(byte)0x83, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x22, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x23, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x01, (byte)0x4D, (byte)0x47, (byte)0x4F, (byte)0x32,
				(byte)0x2D, (byte)0x41, (byte)0x75, (byte)0x74, (byte)0x68, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
				(byte)0x31, (byte)0x39, (byte)0x32, (byte)0x2E, (byte)0x33, (byte)0x2E,
				(byte)0x32, (byte)0x31, (byte)0x37, (byte)0x2E, (byte)0x36, (byte)0x31,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x16, (byte)0x64, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x23, (byte)0x00, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x24, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02,
				(byte)0x4F, (byte)0x74, (byte)0x61, (byte)0x63, (byte)0x6F, (byte)0x6E,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x31, (byte)0x39,
				(byte)0x32, (byte)0x2E, (byte)0x33, (byte)0x2E, (byte)0x32, (byte)0x31,
				(byte)0x37, (byte)0x2E, (byte)0x36, (byte)0x31, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x16, (byte)0x65, (byte)0x00, (byte)0x22, (byte)0x00,
				(byte)0x24, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x25,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x4D, (byte)0x69,
				(byte)0x6C, (byte)0x6C, (byte)0x65, (byte)0x72, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x31, (byte)0x39, (byte)0x32, (byte)0x2E,
				(byte)0x33, (byte)0x2E, (byte)0x32, (byte)0x31, (byte)0x37, (byte)0x2E,
				(byte)0x36, (byte)0x31, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x16,
				(byte)0x66, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x25, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x26, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x02, (byte)0x43, (byte)0x61, (byte)0x6D, (byte)0x70,
				(byte)0x62, (byte)0x65, (byte)0x6C, (byte)0x6C, (byte)0x00, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
				(byte)0x31, (byte)0x39, (byte)0x32, (byte)0x2E, (byte)0x33, (byte)0x2E,
				(byte)0x32, (byte)0x31, (byte)0x37, (byte)0x2E, (byte)0x36, (byte)0x31,
				(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x16, (byte)0x67, (byte)0x00,
				(byte)0x00, (byte)0x00, (byte)0x26, (byte)0x00
			};

			ByteBuf payload = ctx.alloc().directBuffer(rawData.length);
			payload.writeBytes(rawData);
			
			ctx.write(new Packet(0x2003, payload));

			ctx.write(new Packet(0x2004));
			break;

		case 0x2008:
			ctx.write(new Packet(0x2009));

			ctx.write(new Packet(0x200b));
			break;

		default:
			System.out.println("Couldn't handle command " + Integer.toHexString(in.getCommand()));
			return false;
		}

		return true;
	}

}