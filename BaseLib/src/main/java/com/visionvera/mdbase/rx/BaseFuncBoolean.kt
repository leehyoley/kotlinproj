package com.visionvera.mdbase.rx

import com.visionvera.mdbase.common.ResultCode
import com.visionvera.mdbase.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/*
    Boolean类型转换封装
 */
class BaseFuncBoolean<T>: Func1<BaseResp<T>, Observable<Boolean>> {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status, t.message))
        }

        return Observable.just(true)
    }
}
