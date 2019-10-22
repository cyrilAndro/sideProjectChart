package cyril.cieslak.sideprojectchart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class MainActivity : AppCompatActivity() {

    lateinit var mpLineChart: LineChart
    lateinit var lineDataSet1: LineDataSet
    lateinit var lineDataSet2 : LineDataSet
    lateinit var dataSets: ArrayList<ILineDataSet>
    lateinit var description : Description

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mpLineChart = findViewById(R.id.line_chart)
        lineDataSet1 = LineDataSet(dataValues1(), "Data Set 1")
        lineDataSet2 = LineDataSet(dataValues2(), "Data Set 2")
        dataSets = ArrayList()
        dataSets.add(lineDataSet1)
        dataSets.add(lineDataSet2)

        mpLineChart.setNoDataText("NoDatas")
        mpLineChart.setNoDataTextColor(Color.BLUE)

        mpLineChart.setDrawGridBackground(true)
        mpLineChart.setDrawBorders(true)

        lineDataSet1.setCircleColors(Color.GREEN)
        lineDataSet1.setColor(Color.GREEN, 100)
        lineDataSet1.lineWidth = 2F
        lineDataSet1.valueTextSize = 10F
        lineDataSet1.valueTextColor = Color.GREEN

        description = Description()
        description.text = "Bingo"


        var data = LineData(dataSets)
        var getDat = data

        mpLineChart.data = getDat
        mpLineChart.invalidate()

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

    private fun dataValues2(): ArrayList<Entry> {
        val dataVals = ArrayList<Entry>()
        dataVals.add(Entry(0F, 12F))
        dataVals.add(Entry(1F, 18F))
        dataVals.add(Entry(2F, 24F))
        dataVals.add(Entry(3F, 44F))
        dataVals.add(Entry(4F, 12F))

        Log.i("banga", " dataVals: $dataVals")

        return dataVals
    }
}
