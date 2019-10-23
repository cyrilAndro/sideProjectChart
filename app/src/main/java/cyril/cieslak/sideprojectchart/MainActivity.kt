package cyril.cieslak.sideprojectchart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ViewPortHandler

class MainActivity : AppCompatActivity() {

    lateinit var mpLineChart: LineChart
    lateinit var lineDataSet1: LineDataSet
    lateinit var lineDataSet2: LineDataSet
    lateinit var dataSets: ArrayList<ILineDataSet>
    lateinit var description: Description

    lateinit var mpBarChart : BarChart
    lateinit var barDataSet1 : BarDataSet
    lateinit var barDataSet2 : BarDataSet
    lateinit var barDataSets : ArrayList<IBarDataSet>

    lateinit var mpCombinedChart : CombinedChart
    lateinit var barDataSetForCombined : BarDataSet
    lateinit var linedataSetForCombined : LineDataSet
    lateinit var lineDataSetsForCombined : ArrayList<ILineDataSet>
    lateinit var barDataSetsForCombined : ArrayList<IBarDataSet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mpLineChart = findViewById(R.id.line_chart)
        lineDataSet1 = LineDataSet(dataValues1(), "Data Set 1")
        lineDataSet2 = LineDataSet(dataValues2(), "Data Set 2")
        dataSets = ArrayList()
        dataSets.add(lineDataSet1)
        dataSets.add(lineDataSet2)

        var xAxis: XAxis = mpLineChart.xAxis
        var yAxisLeft: YAxis = mpLineChart.axisLeft
        var yAxisRight: YAxis = mpLineChart.axisRight

        var xAxisValues = ArrayList<String>()
        xAxisValues.add(0 , "0")
        xAxisValues.add(1, "3h")
        xAxisValues.add(2, "6h")
        xAxisValues.add(3, "9h")
        xAxisValues.add(4, "12h")
        xAxisValues.add(5, "15h")
        xAxisValues.add(6, "18h")
        xAxisValues.add(7, "21h")




        var yAxisLeftValues = ArrayList<String>()
        yAxisLeftValues.add(0, "0")
        yAxisLeftValues.add(1, "5")
        yAxisLeftValues.add(2 ,"10")
        yAxisLeftValues.add(3, "15")
        yAxisLeftValues.add(4, "20")
        yAxisLeftValues.add(5, "25")
        yAxisLeftValues.add(6, "30")
        yAxisLeftValues.add(7, "35")


        var yAxisRightValues = ArrayList<String>()
        yAxisRightValues.add(0, "0.0")
        yAxisRightValues.add(1, "5.0")
        yAxisRightValues.add(2, "10.0")
        yAxisRightValues.add(3, "15.0")
        yAxisRightValues.add(4, "20.0")
        yAxisRightValues.add(5, "25.0")
        yAxisRightValues.add(6, "30")
        yAxisRightValues.add(7, "35")

     //   xAxis.valueFormatter(myAxisValueFormatter().getFormattedValue())
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.setValueFormatter(IndexAxisValueFormatter(xAxisValues))
      //  xAxis.setCenterAxisLabels(true)
        xAxis.setGranularity(1F)
        xAxis.isGranularityEnabled = true


        yAxisLeft.setValueFormatter(IndexAxisValueFormatter(yAxisLeftValues))


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


        // BAR CHART

        mpBarChart = findViewById(R.id.bar_chart)
        barDataSet1 = BarDataSet(dataValuesBar1(), "BarDataSet 1")
        barDataSet2 = BarDataSet(dataValuesBar2(), "BarDataSet 2")
        barDataSets = ArrayList()
        barDataSets.add(barDataSet1)
        barDataSets.add(barDataSet2)

        barDataSet2.setColor(Color.GREEN)

        var xBarAxis : XAxis = mpBarChart.xAxis

        var xBarAxisValue = ArrayList<String>()

        xBarAxisValue.add(0, "0")
        xBarAxisValue.add(1, "3h")
        xBarAxisValue.add(2, "6h")
        xBarAxisValue.add(3, "9h")
        xBarAxisValue.add(4, "12h")
        xBarAxisValue.add(5, "15h")
        xBarAxisValue.add(6, "18h")
        xBarAxisValue.add(7, "21h")

        xBarAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xBarAxis.setValueFormatter(IndexAxisValueFormatter(xBarAxisValue))
        xBarAxis.setGranularity(1F)
        xBarAxis.isGranularityEnabled = true

        var ladata = BarData(barDataSets)
        mpBarChart.data = ladata
        mpBarChart.invalidate()


        // GROUPED BAR CHART

        mpCombinedChart = findViewById(R.id.combine_chart)
        mpCombinedChart.setDrawOrder(arrayOf<CombinedChart.DrawOrder>(CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE))


    }

    private fun dataValues1(): ArrayList<Entry> {
        val dataVals = ArrayList<Entry>()
        dataVals.add(Entry(0F, 20F))
        dataVals.add(Entry(1F, 42F))
        dataVals.add(Entry(2F, 15F))
        dataVals.add(Entry(3F, 3F))
        dataVals.add(Entry(4F, 24F))
        dataVals.add(Entry(5F, 18F))
        dataVals.add(Entry(6F, 35F))
        dataVals.add(Entry(7F, 39F))

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
        dataVals.add(Entry(5F, 24F))
        dataVals.add(Entry(6F, 29F))
        dataVals.add(Entry(7F, 34F))

        Log.i("banga", " dataVals: $dataVals")

        return dataVals
    }


    private fun dataValuesBar1(): ArrayList<BarEntry> {
        val dataVals = ArrayList<BarEntry>()
        dataVals.add(BarEntry(0F, 18F))
        dataVals.add(BarEntry(1F, 14F))
        dataVals.add(BarEntry(2F, 42F))
        dataVals.add(BarEntry(3F, 28F))
        dataVals.add(BarEntry(4F, 16F))
        dataVals.add(BarEntry(5F, 22F))
        dataVals.add(BarEntry(6F, 34F))
        dataVals.add(BarEntry(7F, 39F))



        Log.i("banga", " dataVals: $dataVals")

        return dataVals
    }

    private fun dataValuesBar2(): ArrayList<BarEntry> {
        val dataVals = ArrayList<BarEntry>()
        dataVals.add(BarEntry(0F, 2F))
        dataVals.add(BarEntry(1F, 7F))
        dataVals.add(BarEntry(2F, 18F))
        dataVals.add(BarEntry(3F, 15F))
        dataVals.add(BarEntry(4F, 38F))
        dataVals.add(BarEntry(5F, 12F))
        dataVals.add(BarEntry(6F, 18F))
        dataVals.add(BarEntry(7F, 30F))



        Log.i("banga", " dataVals: $dataVals")

        return dataVals
    }


        // COMBINED CHART














    private class myValueFormatter : IValueFormatter {

        override fun getFormattedValue(
            value: Float,
            entry: Entry?,
            dataSetIndex: Int,
            viewPortHandler: ViewPortHandler?
        ): String {

            return "$value + EUR"
        }
    }

   private class myAxisValueFormatter : IAxisValueFormatter {
        override fun getFormattedValue(value: Float, axis: AxisBase?): String {

            return "Day + $value"
        }

    }

}
