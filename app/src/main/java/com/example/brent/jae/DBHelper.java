package com.example.brent.jae;

/**
 * Created by Brent on 3/29/2015.
 */

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Test on 3/28/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // DB Name
    private static final String DATABASE_NAME = "questionsDB";
    // Questions table
    private static final String QUESTION_TABLE = "question_table";
    // DB columns for id, question, answer and knows
    private static final String KEY_ID = "id";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_KNOWS = "knows";
    private static final String KEY_CATEGORY = "category";
    private SQLiteDatabase dBase;
    //DBHelper dbHelper;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        deleteDb(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS "
                + QUESTION_TABLE + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_QUESTION + " TEXT, "
                + KEY_ANSWER + " TEXT, "
                + KEY_KNOWS + " INTEGER, "
                + KEY_CATEGORY + " INTEGER)";
        db.execSQL(sql); // + KEY_KNOWS + " BOOLEAN)";
        //QManager qm = new QManager();
        //qm.popData();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table
        db.execSQL("DROP TABLE IF EXISTS " + QUESTION_TABLE);
        // Create table agai
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    // Adding new question
    public void addQuestion(Question quest) {
        // dbase.execSQL("INSERT INTO" + QUESTION_TABLE (KEY_ID, KEY_QUESTION, KEY_ANSWER, KEY_KNOWS, KEY_CATEGORY) );
        // dbbase.exec

        dBase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, quest.getQuestion());
        values.put(KEY_ANSWER, quest.getAnswer());
        values.put(KEY_KNOWS, quest.getKnown());
        values.put(KEY_CATEGORY, quest.getCategory());
        // long newRowId;
        dBase.insert(QUESTION_TABLE, null, values);
        // dbHelper.close();

    }
    // method to return all the objs as a linked array list
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT * FROM " + QUESTION_TABLE;
        dBase = this.getReadableDatabase();
        Cursor cursor = dBase.rawQuery(selectQuery, null);

        // Looping through the database rows
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setKnown(cursor.getInt(3));
                quest.setCategory(cursor.getInt(4));
                quesList.add(quest);
            } while(cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getCat(int cat){
        List<Question> questions = new ArrayList<>();
        // SQL query to get everything matching the category
        String query = "SELECT * FROM " + QUESTION_TABLE + " where category = " + cat;
        dBase = this.getReadableDatabase();
        Cursor cursor = dBase.rawQuery(query, null);
        if(cat == 0){
            return getAllQuestions();
        }
        else {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQuestion(cursor.getString(1));
                    quest.setAnswer(cursor.getString(2));
                    quest.setKnown(cursor.getInt(3));
                    quest.setCategory(cursor.getInt(4));
                    questions.add(quest);
                } while (cursor.moveToNext());
            }
        }
        return questions;
    }

    public void setKnown(int question) {
        String sql = "UPDATE " + QUESTION_TABLE +
                "SET " + KEY_KNOWS + "=1 " +
                "WHERE " + KEY_ID + "= " + question;
        dBase = this.getWritableDatabase();
        dBase.execSQL(sql);
    }

    public void deleteDb(Context context){
        // delete database
        context.deleteDatabase(DATABASE_NAME);
    }

}
