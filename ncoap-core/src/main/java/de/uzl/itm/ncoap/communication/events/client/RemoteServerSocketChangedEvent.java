/**
 * Copyright (c) 2012, Oliver Kleine, Institute of Telematics, University of Luebeck
 * All rights reserved
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *  - Redistributions of source messageCode must retain the above copyright notice, this list of conditions and the following
 *    disclaimer.
 *
 *  - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 *    following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 *  - Neither the name of the University of Luebeck nor the names of its contributors may be used to endorse or promote
 *    products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package de.uzl.itm.ncoap.communication.events.client;

import de.uzl.itm.ncoap.communication.dispatching.client.Token;
import de.uzl.itm.ncoap.communication.events.AbstractMessageTransferEvent;

import java.net.InetSocketAddress;

/**
 * Created by olli on 31.08.15.
 */
public class RemoteServerSocketChangedEvent extends AbstractMessageTransferEvent {

    private final InetSocketAddress previous;

    /**
     * Creates a new instance of {@link de.uzl.itm.ncoap.communication.events.AbstractMessageTransferEvent}
     *
     * @param remoteSocket the remote endpoint of the
     *                       {@link de.uzl.itm.ncoap.communication.reliability.outbound.MessageTransfer} that caused this
     *                       event
     * @param messageID      the message ID of the {@link de.uzl.itm.ncoap.communication.reliability.outbound.MessageTransfer}
     *                       that caused this event
     * @param token          the {@link de.uzl.itm.ncoap.communication.dispatching.client.Token} of the
     *                       {@link de.uzl.itm.ncoap.communication.reliability.outbound.MessageTransfer} that caused this event
     */
    public RemoteServerSocketChangedEvent(InetSocketAddress remoteSocket, InetSocketAddress previous, int messageID,
                                          Token token) {

        super(remoteSocket, messageID, token);
        this.previous = previous;

    }


    public InetSocketAddress getPreviousRemoteSocket() {
        return previous;
    }

    @Override
    public String toString(){
        return "REMOTE SERVER SOCKET CHANGED (old: " + this.getPreviousRemoteSocket() + ", new: " + this.getRemoteSocket() +
                ", Token: " + this.getToken() + ")";
    }

    public interface Handler {
        public void handleEvent(RemoteServerSocketChangedEvent event);
    }
}