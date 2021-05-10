package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentMapper;
import com.ruoyi.system.domain.Student;
import com.ruoyi.system.service.IStudentService;
import com.ruoyi.common.core.text.Convert;

/**
 * studentService业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-23
 */
@Service
public class StudentServiceImpl implements IStudentService 
{
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询student
     * 
     * @param id studentID
     * @return student
     */
    @Override
    public Student selectStudentById(Long id)
    {
        return studentMapper.selectStudentById(id);
    }

    /**
     * 查询student列表
     * 
     * @param student student
     * @return student
     */
    @Override
    public List<Student> selectStudentList(Student student)
    {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 新增student
     * 
     * @param student student
     * @return 结果
     */
    @Override
    public int insertStudent(Student student)
    {
        student.setCreateTime(DateUtils.getNowDate());
        return studentMapper.insertStudent(student);
    }

    /**
     * 修改student
     * 
     * @param student student
     * @return 结果
     */
    @Override
    public int updateStudent(Student student)
    {
        student.setUpdateTime(DateUtils.getNowDate());
        return studentMapper.updateStudent(student);
    }

    /**
     * 删除student对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStudentByIds(String ids)
    {
        return studentMapper.deleteStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除student信息
     * 
     * @param id studentID
     * @return 结果
     */
    @Override
    public int deleteStudentById(Long id)
    {
        return studentMapper.deleteStudentById(id);
    }
}
