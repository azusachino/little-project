<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input
        v-model="questParam.parameter"
        placeholder="请输入搜索内容"
        style="width: 300px;"
        class="filter-item"
        @keyup.enter.native="handleFilter"/>
      <el-select
        v-model="questParam.typeId"
        placeholder="请选择题型"
        clearable
        style="width: 120px"
        class="filter-item"
        value="">
        <el-option v-for="type in types" :key="type.idx" :label="type.value" :value="type.idx"/>
      </el-select>
      <el-select
        v-model="questParam.gradeId"
        placeholder="请选择年级"
        clearable
        style="width: 120px"
        class="filter-item"
        value="">
        <el-option v-for="grade in grades" :key="grade.idx" :label="grade.value" :value="grade.idx"/>
      </el-select>
      <el-select
        v-model="questParam.subjectId"
        placeholder="请选择科目"
        clearable
        style="width: 120px"
        class="filter-item"
        value="">
        <el-option v-for="subject in subjects" :key="subject.idx" :label="subject.value" :value="subject.idx"/>
      </el-select>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        Search
      </el-button>
      <el-button
        class="filter-item"
        style="margin-left: 10px;"
        type="primary"
        icon="el-icon-edit"
        @click="handleCreate">
        Add
      </el-button>
    </div>
    <el-table
      :key="tableKey"
      v-loading="listLoading"
      :data="dataList"
      border
      :fit="fit"
      highlight-current-row
      style="width: 100%"
      @sort-change="sortChange">
      <el-table-column
        label="试题ID"
        prop="id"
        sortable="custom"
        align="center"
        :class-name="getSortClass('id')">
        <template slot-scope="scope">
          <span>{{ scope.row.questionId }}</span>
        </template>
      </el-table-column>
      <el-table-column label="标题" align="center" show-tooltip-when-overflow>
        <template slot-scope="scope">
          <span>{{ scope.row.title }}</span>
        </template>
      </el-table-column>
      <el-table-column label="A" align="center" show-tooltip-when-overflow>
        <template slot-scope="scope">
          <span>{{ scope.row.optionA }}</span>
        </template>
      </el-table-column>
      <el-table-column label="B" align="center" show-tooltip-when-overflow>
        <template slot-scope="scope">
          <span>{{ scope.row.optionB }}</span>
        </template>
      </el-table-column>
      <el-table-column label="C" align="center" show-tooltip-when-overflow>
        <template slot-scope="scope">
          <span>{{ scope.row.optionC }}</span>
        </template>
      </el-table-column>
      <el-table-column label="D" align="center" show-tooltip-when-overflow>
        <template slot-scope="scope">
          <span>{{ scope.row.optionD }}</span>
        </template>
      </el-table-column>
      <el-table-column label="答案" align="center" show-tooltip-when-overflow>
        <template slot-scope="scope">
          <span>{{ scope.row.answer }}</span>
        </template>
      </el-table-column>
      <el-table-column label="参考" align="center" show-tooltip-when-overflow>
        <template slot-scope="scope">
          <span>{{ scope.row.remark }}</span>
        </template>
      </el-table-column>
      <el-table-column label="题型" align="center">
        <template slot-scope="scope">
          <el-tag>{{ scope.row.type }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="年级" align="center">
        <template slot-scope="scope">
          <el-tag>{{ scope.row.grade }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="科目" align="center">
        <template slot-scope="scope">
          <el-tag>{{ scope.row.subject }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新时间" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.updateTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center">
        <template slot-scope="{row}">
          <el-tag :type="row.status | statusFilter">
            {{ row.status | statusFilter2}}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="Actions" align="center" width="230" class-name="small-padding fixed-width">
        <template slot-scope="{row}">
          <el-button type="primary" size="mini" @click="handleUpdate(row)">
            Edit
          </el-button>
          <el-button size="mini" type="danger" @click="handleModifyStatus(row, 2)">
            Delete
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="questParam.current"
      :limit.sync="questParam.size"
      @pagination="getList"/>
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form
               ref="dataForm"
               :rules="rules"
               :model="temp"
               label-position="left"
               label-width="70px"
               style="width: 400px; margin-left:50px;">
        <el-form-item label="Title" prop="title">
          <el-input v-model="temp.title" />
        </el-form-item>
        <el-form-item label="type">
          <el-select v-model="temp.type" class="filter-item" placeholder="Please select" value="">
            <el-option v-for="item in types" :key="item.idx" :label="item.value" :value="item.idx" />
          </el-select>
        </el-form-item>
        <el-form-item label="Subject" prop="subject">
          <el-select v-model="temp.subject" class="filter-item" placeholder="Please select" value="">
            <el-option v-for="subject in subjects" :key="subject.idx" :label="subject.value" :value="subject.idx"/>
          </el-select>
        </el-form-item>
        <el-form-item label="Difficulty">
          <el-rate v-model="temp.importance" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" :max="3" style="margin-top:8px;" />
        </el-form-item>
        <el-form-item label="Remark">
          <el-input v-model="temp.remark" :autosize="{ minRows: 2, maxRows: 4}" type="textarea" placeholder="Please input" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">
          Cancel
        </el-button>
        <el-button type="primary" @click="dialogStatus==='create'?createData():updateData()">
          Confirm
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { add, fetchList, update } from '@/api/question'
import { mapGetters } from 'vuex'
import { parseTime } from '../../utils'
import Pagination from '../../components/Pagination'

export default {
  name: 'List',
  components: { Pagination },
  filters: {
    statusFilter(status) {
      const statusMap = {
        '1': 'success',
        '0': 'info',
        '2': 'danger'
      }
      return statusMap[status]
    },
    statusFilter2(status) {
      const statusMap = {
        '1': '正常使用',
        '0': '编辑中',
        '2': '已废弃'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      tableKey: 0,
      dataList: null,
      total: 0,
      listLoading: false,
      fit: true,
      questParam: {
        current: 1,
        size: 10,
        parameter: '',
        typeId: '',
        subjectId: '',
        gradeId: ''
      },
      temp: {
        title: '',
        typeId: '',
        subjectId: '',
        gradeId: '',
        knowledgeId: '',
        userId: '',
        difficulty: ''

      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: 'Edit',
        create: 'Create'
      }
    }
  },
  computed: {
    ...mapGetters([
      'types', 'subjects', 'grades'
    ])
  },
  beforeMount() {
    this.$store.dispatch('code/getCode')
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      fetchList(this.questParam)
        .then(r => {
          this.dataList = r.data.records
          this.total = r.data.total
          // Just to simulate the time of the request
        })
        .catch((e) => {
          console.log(e)
        }).finally(() => {
          this.listLoading = false
        })
    },
    handleFilter() {
      this.questParam.page = 1
      this.getList()
    },
    handleModifyStatus(row, status) {
      this.$message({
        message: '操作Success',
        type: 'success'
      })
      row.status = status
    },
    sortChange(data) {
      const { prop, order } = data
      if (prop === 'id') {
        this.sortByID(order)
      }
    },
    sortByID(order) {
      if (order === 'ascending') {
        this.questParam.sort = '+id'
      } else {
        this.questParam.sort = '-id'
      }
      this.handleFilter()
    },
    resetTemp() {
      this.temp = {
        id: undefined,
        importance: 1,
        remark: '',
        timestamp: new Date(),
        title: '',
        status: 'published',
        type: ''
      }
    },
    handleCreate() {
      this.resetTemp()
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    createData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          add(this.temp).then(() => {
            this.list.unshift(this.temp)
            this.dialogFormVisible = false
            this.$notify({
              title: 'Success',
              message: 'Created Successfully',
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    handleUpdate(row) {
      this.temp = Object.assign({}, row) // copy obj
      this.temp.timestamp = new Date(this.temp.timestamp)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    updateData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          const tempData = Object.assign({}, this.temp)
          tempData.timestamp = +new Date(tempData.timestamp) // change Thu Nov 30 2017 16:41:05 GMT+0800 (CST) to 1512031311464
          update(tempData).then(() => {
            for (const v of this.list) {
              if (v.id === this.temp.id) {
                const index = this.list.indexOf(v)
                this.list.splice(index, 1, this.temp)
                break
              }
            }
            this.dialogFormVisible = false
            this.$notify({
              title: 'Success',
              message: 'Update Successfully',
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    handleDelete(row) {
      this.$notify({
        title: 'Success',
        message: 'Delete Successfully',
        type: 'success',
        duration: 2000
      })
      const index = this.list.indexOf(row)
      this.list.splice(index, 1)
    },
    formatJson(filterVal, jsonData) {
      return jsonData.map(v => filterVal.map(j => {
        if (j === 'timestamp') {
          return parseTime(v[j])
        } else {
          return v[j]
        }
      }))
    },
    getSortClass: function(key) {
      const sort = this.questParam.sort
      return sort === `+${key}`
        ? 'ascending'
        : sort === `-${key}`
          ? 'descending'
          : ''
    }
  }
}
</script>

<style scoped>

</style>
