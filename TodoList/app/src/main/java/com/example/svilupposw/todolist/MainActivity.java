package com.example.svilupposw.todolist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;


public class MainActivity extends AppCompatActivity {

    private ListAdapter lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater factory = LayoutInflater.from(getApplicationContext());
                final View textEntryView = factory.inflate(R.layout.nuovoimpegno, null);


                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_input_add)
                        .setTitle("Aggiungi impegno")
                        .setView(textEntryView)
                        .setPositiveButton("Aggiungi", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                final EditText inputTitle = (EditText) textEntryView.findViewById(R.id.inputtitle);
                                final EditText inputDescr = (EditText) textEntryView.findViewById(R.id.inputdescr);
                                String title = inputTitle.getText().toString().trim();
                                String descr = inputDescr.getText().toString().trim();
                                //AGGIUNGO AL DATABASE!
                                if(!title.equals("") && !descr.equals(""))
                                {
                                    Firebase listRef = DatabaseConnection.getFbRef().child("todolist");
                                    Firebase newListRef = listRef.push();
                                    DatabaseList todo = new DatabaseList(false, title, descr);
                                    newListRef.setValue(todo);
                                }
                                else
                                {
                                    new AlertDialog.Builder(MainActivity.this)
                                            .setIcon(android.R.drawable.ic_dialog_alert)
                                            .setTitle("Errore")
                                            .setMessage("Titolo e descrizione sono necessari!")
                                            .show();
                                }
                            }

                        })
                        .setNegativeButton("Annulla", null)
                        .show();
            }
        });

        lista = new ListAdapter(MainActivity.this);
        final ListView listView = (ListView) findViewById(R.id.todoList);
        listView.setAdapter(lista);

        DatabaseConnection.getFbRef().child("todolist").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i("onChildAdded", dataSnapshot.getKey());

                //viene chiamata per ogni elemento esistente della lista oppure quando un nuovo elemento viene aggiunto
                DatabaseList newTodo = dataSnapshot.getValue(DatabaseList.class);
                newTodo.setUuid(dataSnapshot.getKey());
                lista.addItem(newTodo);
                Log.i("TITOLO E DESCRIPTION", "Titolo: " + newTodo.getTitle() + " Description: " + newTodo.getDescription());
                Log.i("Key", newTodo.getUuid());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                DatabaseList todo = dataSnapshot.getValue(DatabaseList.class);
                String completato = "Hai completato '"+todo.getTitle()+"'";
                if(!todo.isDone()){
                    completato = "Impostato '"+todo.getTitle()+"' da completare!";
                }
                Toast.makeText(getApplicationContext(), completato, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                DatabaseList toRemove = dataSnapshot.getValue(DatabaseList.class);
                toRemove.setUuid(dataSnapshot.getKey());
                Log.i("Cancellato", "");
                lista.removeItem(toRemove.getUuid());


            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("ciaone", "ciaone");
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("ciao","ciao");
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("ciao","ciao");
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(getApplicationContext(), SingleUserShow.class);
                intent.putExtra("username", usernames[position]);
                intent.putExtra("email", emails[position]);
                intent.putExtra("description", descriptions[position]);
                startActivity(intent);*/
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
