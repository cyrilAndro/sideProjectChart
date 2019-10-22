package cyril.cieslak.sideprojectchart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class MainActivity : AppCompatActivity() {

    lateinit var mpLineChart : LineChart
    lateinit var lineDataSet1 : LineDataSet
    lateinit var dataSets : ArrayList<ILineDataSet>
  //  lateinit var data : LineData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mpLineChart = findViewById(R.id.line_chart)
        lineDataSet1 = LineDataSet(dataValues1(), "Data Set 1")
        dataSets = ArrayList()
        dataSets.add(lineDataSet1)

        Log.i("banga", " dataSets: $dataSets")


        var data = LineData(dataSets)

        Log.i("banga", " data: $data")

        var getDat = data

        mpLineChart.setData(getDat)
        mpLineChart.invalidate()

//        LineData data = new LineData(dataSets);
//        mpLineChart.setData(data);
//        mpLineChart.invalidate()


    }

    private fun dataValues1(): ArrayList<Entry> {
        val dataVals = ArrayList<Entry>()
        dataVals.add(Entry(0F, 20F))
        dataVals.add(Entry(1F, 42F))
        dataVals.add(Entry(2F, 15F))
        dataVals.add(Entry(3F, 3F))
        dataVals.add(Entry(4F, 38F))

        Log.i("banga", " dataVals: $dataVals")

        return dataVals
    }

//    private ArrayList<Entry> dataValues1 () {
//
//        ArrayList<Entry> dataVals = new ArrayList <Entry> ();
//        dataVals.add(new Entry(0, 20));
//        dataVals.add(new Entry(1, 42));
//        dataVals.add(new Entry(2, 15));
//        dataVals.add(new Entry(3, 3));
//        dataVals.add(new Entry(4, 38));
//
//        return dataVals;
//
//    }
}
