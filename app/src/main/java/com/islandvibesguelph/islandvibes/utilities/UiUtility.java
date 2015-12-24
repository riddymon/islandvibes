package com.islandvibesguelph.islandvibes.utilities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.widget.Toast;

import com.islandvibesguelph.islandvibes.IslandVibesApplication;
import com.islandvibesguelph.islandvibes.R;

/**
 * Created by djriddy on 2015-12-23.
 */
public class UiUtility {

    public static void createToastMessage(final Activity activity, final String mValue){

        activity.runOnUiThread(new Thread(new Runnable() {
            public void run() {
                Toast.makeText(activity, mValue, Toast.LENGTH_SHORT).show();
            }
        }));

    }

    public static void createToastMessage(Context context, final String mValue){
        Toast.makeText(context, mValue, Toast.LENGTH_SHORT).show();
    }

    public static void createConfirmationDialog(final Activity activity, final String positiveText, final DialogInterface.OnClickListener btnPositive,
                                                final String negativeText, final DialogInterface.OnClickListener btnNegative, final String title, final String txtMessage, final boolean isCancelable){

        activity.runOnUiThread(new Thread(new Runnable() {
            public void run() {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.IslandVibesAlertDialogTheme)
                            .setMessage(txtMessage)
                            .setCancelable(isCancelable)
                            .setPositiveButton(positiveText, btnPositive)
                            .setNegativeButton(negativeText, btnNegative);

                    if (title != null) {
                        builder.setTitle(title);
                    }

                    builder.create().show();
                } catch (Exception e) {
                    LogUtility.error("Error showing dialog", e);
                }
            }
        }));

    }

    public static void createConfirmationDialog(final Activity activity, final String positiveText, final DialogInterface.OnClickListener btnPositive,
                                                final String negativeText, final DialogInterface.OnClickListener btnNegative, final String title, final String txtMessage){
        createConfirmationDialog(activity, positiveText, btnPositive, negativeText, btnNegative, title, txtMessage, false);
    }

    public static void createConfirmationDialog(final Activity activity, final int positiveText, final DialogInterface.OnClickListener btnPositive,
                                                final int negativeText, final DialogInterface.OnClickListener btnNegative, final int txtMessage, boolean isCancellable){

        Context context = IslandVibesApplication.getAppContext();
        String positiveTextStr = context.getString(positiveText);
        String negativeTextStr = context.getString(negativeText);
        String txtMessageStr = context.getString(txtMessage);
        createConfirmationDialog(activity, positiveTextStr, btnPositive, negativeTextStr, btnNegative, txtMessageStr, isCancellable);

    }

    public static void createConfirmationDialog(final Activity activity, final int positiveText, final DialogInterface.OnClickListener btnPositive,
                                                final int negativeText, final DialogInterface.OnClickListener btnNegative, final int txtMessage){

        createConfirmationDialog(activity, positiveText, btnPositive, negativeText, btnNegative, txtMessage, false);

    }

    public static void createConfirmationDialog(final Activity activity, final String positiveText, final DialogInterface.OnClickListener btnPositive,
                                                final String negativeText, final DialogInterface.OnClickListener btnNegative, final String txtMessage){

        createConfirmationDialog(activity, positiveText, btnPositive, negativeText, btnNegative, null, txtMessage, false);
    }


    public static void createConfirmationDialog(final Activity activity, final String positiveText, final DialogInterface.OnClickListener btnPositive,
                                                final String negativeText, final DialogInterface.OnClickListener btnNegative, final String txtMessage, boolean isCancellable){

        createConfirmationDialog(activity, positiveText, btnPositive, negativeText, btnNegative, null, txtMessage, isCancellable);
    }

    public static void createAlertDialog(final Activity activity, final DialogInterface.OnClickListener btnListenOk, final String title, final String txtMessage){

        activity.runOnUiThread (new Thread(new Runnable() {
            public void run() {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.IslandVibesAlertDialogTheme)
                            .setMessage(txtMessage)
                            .setCancelable(false)
                            .setPositiveButton(activity.getString(R.string.btnOK), btnListenOk);

                    if (title != null) {
                        builder.setTitle(title);
                    }

                    builder.create().show();
                } catch (Exception e) {
                    LogUtility.error("Error showing dialog", e);
                }

            }
        }));
    }

    public static void createAlertDialog(final Activity activity, final DialogInterface.OnClickListener btnListenOk, final int resIdTitle, final int resIdMsg){
        final String message = activity.getString(resIdMsg);
        final String title = activity.getString(resIdTitle);
        createAlertDialog(activity, btnListenOk, title, message);
    }

    public static void createAlertDialog(final Activity activity, final DialogInterface.OnClickListener btnListenOk, final String message){
        createAlertDialog(activity, btnListenOk, null, message);
    }

    public static void createAlertDialog(final Activity activity, final DialogInterface.OnClickListener btnListenOk, int resid){

        final String message = activity.getString(resid);
        createAlertDialog(activity, btnListenOk, null, message);

    }

    public static void createLoginDialog(final Activity activity) {

//        activity.runOnUiThread (new Thread(new Runnable() {
//            public void run() {
//                final View view = activity.getLayoutInflater().inflate(R.layout.dialog_login, null);
//
//                final DialogInterface.OnClickListener onClickLogin = new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        UserInfo userInfo = AAUtility.get(UserInfo.class);
//                        String username = userInfo.getUid();
//                        String domain = userInfo.getDomain();
//                        EditText editPassword = (EditText)view.findViewById(R.id.editPassword);
//                        String password = editPassword.getText().toString();
//                        NetworkUtility.getInstance().submitLogin(username, password, domain);
//                    }
//                };
//
//                final DialogInterface.OnClickListener onClickCancel = new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        NetworkUtility.getInstance().submitLoginFailure();
//                    }
//                };
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.RBCAlertDialogTheme)
//                        .setTitle(activity.getString(R.string.lblEnterPassword))
//                        .setCancelable(false)
//                        .setPositiveButton(activity.getString(R.string.btnLogin), onClickLogin)
//                        .setNegativeButton(activity.getString(R.string.btnCancel), onClickCancel)
//                        .setView(view);
//                final AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        }));
    }

    public static String stripHtml(String html) {
        String plainText = Html.fromHtml(html).toString();
        plainText = plainText.replaceAll("(?s)<!--.*?-->", "");
        plainText = plainText.trim();
        return plainText;
    }

}