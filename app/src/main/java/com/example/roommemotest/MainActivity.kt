package com.example.roommemotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roommemotest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MemoAdapter.ItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var memoAdapter: MemoAdapter
    private var selectedMemo: Memo? = null
//    private val updateAddMemoResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()
//    ) { result ->
//        val isUpdated = result.data?.getBooleanExtra("isUpdate", false) ?: false
//        if (result.resultCode == RESULT_OK && isUpdated) {
//            updateAddMemo()
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        memoAdapter = MemoAdapter(mutableListOf(), this)
        binding.recyclerView.apply {
            adapter = memoAdapter
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            val divider = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
            addItemDecoration(divider)
        }
    }

    override fun onClick(memo: Memo) {
        selectedMemo = memo
        binding.titleTV.text = memo.title
        binding.bodyTV.text = memo.body
    }
}