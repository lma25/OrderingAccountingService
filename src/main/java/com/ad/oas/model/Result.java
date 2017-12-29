package com.ad.oas.model;

import com.ad.oas.constant.OASConstant;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Result {
    @NonNull
    private String action;
    @NonNull
    private boolean success;
    private String errorMessage = OASConstant.DEFAULT_MESSAGE_VALUE;
    private String returnMessage = OASConstant.DEFAULT_MESSAGE_VALUE;

    public void setErrorMessage(@NonNull final String errorMessage) {
        this.errorMessage = errorMessage + '\n';
    }

    // success marker will be change to false in this function.
    public void appendErrorMessage(@NonNull final String errorMessage){
        this.success = false;
        this.errorMessage += errorMessage + '\n';
    }

    // success marker may change due to the new com.ad.oas.util.
    public Result mergeResult(@NonNull final Result result){
        if(!this.action.equals(result.getAction())){
            return null;
        }
        this.success = this.success && result.isSuccess();
        if(result.success == false){
            this.appendErrorMessage(result.getErrorMessage());
        }

        return this;
    }

}