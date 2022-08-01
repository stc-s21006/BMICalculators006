package jp.suntech.s21006.bmicalculators006;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState){
        //ダイアログビルダーを生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログのタイトルを設定
        builder.setTitle(R.string.dialog_title);
        //ダイアログのメッセージを設定
        builder.setMessage(R.string.dialog_msg);
        //Positive Button を設定
        builder.setPositiveButton(R.string.dialog_ok, (dialog, which) -> System.out.println("okがクリックされました"));
        //ダイアログを生成し、リターン
        return builder.create();
    }
}
