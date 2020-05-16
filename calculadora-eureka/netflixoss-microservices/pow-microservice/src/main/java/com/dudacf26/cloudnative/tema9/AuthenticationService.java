package com.dudacf26.cloudnative.tema9;

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import rx.Observable;

public interface AuthenticationService {
    Observable<Boolean> authenticate(HttpServerRequest<ByteBuf> request);
}