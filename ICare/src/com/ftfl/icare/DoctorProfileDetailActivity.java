package com.ftfl.icare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ftfl.icare.database.DoctorProfileDataSource;
import com.ftfl.icare.model.DoctorProfile;

public class DoctorProfileDetailActivity extends Activity {

	// ID
	int mId = 0;

	// variable declaration
	TextView mTvDoctorName = null;
	TextView mTvDoctorDesignation = null;
	TextView mTvDoctorPhone = null;
	TextView mTvDoctorEmail = null;

	// Profile Object
	DoctorProfile mProfile = null;

	// DataSource Object
	DoctorProfileDataSource mDataSource = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor_view_profile);

		// get the Intent that started this Activity
		Intent mIntent = getIntent();

		// get the Bundle that stores the data of this Activity
		Bundle mBundle = mIntent.getExtras();
		mId = mBundle.getInt("id");
		// Initialization
		initialization();

		// Getting All place detail
		mDataSource = new DoctorProfileDataSource(this);
		mProfile = mDataSource.getDoctorDetail(mId);

		// // set value in text view
		mTvDoctorName.setText(mProfile.getmName());
		mTvDoctorDesignation.setText(mProfile.getmDesignation());
		mTvDoctorPhone.setText(mProfile.getmPhone());
		mTvDoctorEmail.setText(mProfile.getmEmail());

	}

	// Initialization
	public void initialization() {
		mTvDoctorName = (TextView) findViewById(R.id.tvDetailDoctorName);
		mTvDoctorDesignation = (TextView) findViewById(R.id.tvDetailDoctorDesignation);
		mTvDoctorPhone = (TextView) findViewById(R.id.tvDetailDoctorPhone);
		mTvDoctorEmail = (TextView) findViewById(R.id.tvDetailDoctorEmail);
	}

	// public void makeCall(View v) {
	//
	// String number = mTextViewContactPhone.getText().toString().trim();
	// Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
	// + number));
	// startActivity(callIntent);
	//
	// }
	//
	// public void sendSms(View v) {
	//
	// String number = mTextViewContactPhone.getText().toString().trim();
	//
	// Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"
	// + number));
	// startActivity(smsIntent);
	// }
	//
	// public void sendEmail(View v) {
	//
	// String[] email = { mTextViewContactEmail.getText().toString() };
	//
	// Intent emailIntent = new Intent(Intent.ACTION_SEND,
	// Uri.parse("mailto:"));
	// emailIntent.setType("text/plain");
	//
	// emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
	// emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
	// emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
	//
	// startActivity(Intent.createChooser(emailIntent, "Send mail..."));
	// }

	// public void addToContact(View v) {
	//
	// ArrayList<ContentProviderOperation> ops = new
	// ArrayList<ContentProviderOperation>();
	// int rawContactInsertIndex = ops.size();
	//
	// ops.add(ContentProviderOperation.newInsert(RawContacts.CONTENT_URI)
	// .withValue(RawContacts.ACCOUNT_TYPE, null)
	// .withValue(RawContacts.ACCOUNT_NAME, null).build());
	// ops.add(ContentProviderOperation
	// .newInsert(Data.CONTENT_URI)
	// .withValueBackReference(Data.RAW_CONTACT_ID,
	// rawContactInsertIndex)
	// .withValue(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE)
	// .withValue(StructuredName.DISPLAY_NAME,
	// mTextViewContactName.getText().toString()) // Name of
	// // the
	// // person
	// .build());
	// ops.add(ContentProviderOperation
	// .newInsert(Data.CONTENT_URI)
	// .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID,
	// rawContactInsertIndex)
	// .withValue(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE)
	// .withValue(Phone.NUMBER,
	// mTextViewContactPhone.getText().toString()) // Number
	// // of
	// // the
	// // person
	// .withValue(Phone.TYPE, Phone.TYPE_MOBILE).build()); // Type of
	// // mobile
	// // number
	// try {
	// ContentProviderResult[] res = getContentResolver().applyBatch(
	// ContactsContract.AUTHORITY, ops);
	//
	// Toast.makeText(getApplicationContext(),
	// "Successfully  Contract Added !!!!!!!", Toast.LENGTH_LONG)
	// .show();
	// } catch (RemoteException e) {
	// // error
	// } catch (OperationApplicationException e) {
	// // error
	// }
	//
	// Intent contacts = new Intent(Intent.ACTION_VIEW,
	// ContactsContract.Contacts.CONTENT_URI);
	// startActivity(contacts);
	//
	// }

	// Update Button Operation
	private void update() {
		Bundle mBundle = new Bundle();
		mBundle.putInt("id", mId);

		// Intent to Doctor Profile Update
		Intent mIntent = new Intent(DoctorProfileDetailActivity.this,
				DoctorProfileUpdateActivity.class);
		mIntent.putExtras(mBundle);
		startActivity(mIntent);
	}

	// Delete Button Operation
	private void delete() {
		mDataSource = new DoctorProfileDataSource(this);
		mDataSource.deleteData(mId);

		// Intent to Doctor Profile List
		Intent mIntent = new Intent(DoctorProfileDetailActivity.this,
				DoctorProfileListActivity.class);
		startActivity(mIntent);

	}

	// view screen menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.doctor_detail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.update) {
			update();
			return true;
		}

		if (id == R.id.delete) {
			delete();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
	}
}
