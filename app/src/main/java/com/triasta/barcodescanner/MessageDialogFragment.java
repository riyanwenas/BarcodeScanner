package com.triasta.barcodescanner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Admin on 13/06/2016.
 */
public class MessageDialogFragment extends DialogFragment {
    public interface MessageDialogListener {
        void onDialogPositiveClick(DialogFragment dialog);
    }

    private String Message;
    private MessageDialogListener mListener;


    public void onCreate(Bundle state) {
        super.onCreate(state);
        setRetainInstance(true);
    }

    public static MessageDialogFragment newInstance(String Message, MessageDialogListener listener) {
        MessageDialogFragment fragment = new MessageDialogFragment();
        fragment.Message = Message;
        fragment.mListener = listener;
        return fragment;
    }

    @Override @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(Message).setTitle("HASIL SCAN");

        builder.setNeutralButton("OKE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (mListener != null) {
                    mListener.onDialogPositiveClick(MessageDialogFragment.this);
                }
            }
        });

        return builder.create();
    }

}
