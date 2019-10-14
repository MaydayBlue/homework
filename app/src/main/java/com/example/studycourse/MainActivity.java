package com.example.studycourse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.studycourse.Adapter.ListAdapter;
import com.example.studycourse.Util.Course;
import com.example.studycourse.Util.SharedPreferencesUtil;
import com.example.studycourse.activity.CourseDetailsActivity;
import com.example.studycourse.activity.LoginActivity;
import com.example.studycourse.activity.SearchActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SharedPreferencesUtil spu;
    private ListView listView;
    private List<Course> courseList = new ArrayList<Course>(); //创建集合保存课程信息

    String[] dcourseIds = {"C语言程序设计","软件测试与质量","线性代数",
            "数字图像处理","数字媒体技术概论","逻辑导论","Python编程基础","智能机器人系统"
    };

    String[] dteachers = {"翁恺","武剑洁","靳全勤","贾永红",
            "严明","陈波","王恺","卢惠民"
    };

    String[] dschool = {"浙江大学","华中科技大学","同济大学",
            "武汉大学","中国传媒大学","北京大学","南开大学","国防科技大学"
    };

    String[] ddate = {"2019-8-12至2019-11-22","2019-11-2至2020-1-15","2019-9-12至2019-12-29",
            "2019-9-30至2019-12-1","2019-10-20至2020-1-1","2019-10-11至2020-12-21",
            "2019-8-20至2020-12-21","2019-10-25至2020-1-25"
    };

    String[] ddescription = {"         C语言是古老而长青的编程语言，它具备了现代程序设计的基础要求，它的语法是很多其他编程语言的基础，在系统程序、嵌入式系统等领域依然是无可替代的编程语言，在各类编程语言排行榜上常年占据前两名的位置。对于非计算机专业的学生，学习本课程的主要目的是掌握程序设计的基本方法，C语言是教学媒介。但是对于计算机专业的学生，本课程是向后续的计算机组成、操作系统、编译原理、体系结构等课程前进的基石，对于C语言本身甚至程序设计语言基础原理的深入理解都是应该掌握的。",
            "         软件测试伴随软件开发的出现而出现，随着软件复杂度的不断攀升，人们又进一步提出软件质量的概念，并提出多种软件质量保证的方法。软件测试课程是软件类和计算机类专业的核心课程。本课程是一门关于软件测试与质量的入门课程，面向软件或计算机专业的学生，或对软件测试有兴趣的学习者，围绕软件测试与质量的基本概念、核心方法、管理与应用、软件质量与度量等内容展开讨论。",
            "         线性代数是普通高等院校普遍开设的一门数学公共基础课，对提高学生的抽象思维能力、逻辑推理能力等具有十分重要的作用。在数字化社会蓬勃发展的今天，数学起着举足轻重的作用，由于各种科学技术的核心往往是数学，众多交叉学科与交叉研究的核心也往往是数学，所以人才竞争中的一个重要环节是培养一大批有较宽视野、有较强创新能力、有较强抽象思维能力和数学素养的人才。",
            "         数字图像处理课程是测绘、遥感科学与技术等专业必修的专业基础课之一。开设该课程的目的是让学生通过本课程的学习，掌握有关数字图像处理的基本概念、方法、原理及应用，培养和增强学生创新意识和创新思维，提高实际动手能力和创新能力。",
            "         数字媒体技术是融合了数字信息处理技术、计算机技术、数字通信和网络技术等多种技术的交叉学科和技术领域。数字媒体技术是通过现代计算和通信手段，综合处理文字、声音、图形、图像、视频等信息，使抽象的信息变成可感知、可管理和可交互的一种技术。通过本门课程的学习，可以让你了解数字媒体技术的前沿研究进展和发展方向，领略数字媒体技术领域的魅力，培养学习相关技术的兴趣和动力。",
            "         此课程试图给学生传授关于逻辑学的一般观念，逻辑学发展到目前为止的大致的整体形象，一些最基本的逻辑技术和技巧，以及隐藏在逻辑技术背后的思想和精神。具体内容包括：第一讲：逻辑学是关于推理和论证的科学；第二讲：命题逻辑，研究由联结词决定的复合命题的逻辑性质以及复合命题之间的推理关系；第三讲：词项逻辑，研究直言命题（性质命题）的逻辑性质及其相互之间的推理关系；第四讲：谓词逻辑，研究量化命题的逻辑性质及其相互之间的推理关系。",
            "         Python是一种代表简单主义思想的语言，可以使用尽量少的代码完成更多工作。Python除了简单易学以外，还具有免费开源、跨平台性、高层语言、面向对象、丰富的库、胶水语言等优点，其已在科学计算、Web开发、数据分析、人工智能等方面有着非常广泛的应用。由于Python的上述优点，不仅大量计算机专业人员使用Python进行快速开发，而且非计算机专业人员也利用Python解决其专业问题。",
            "         智能机器人系统是人工智能与机器人技术的完美结合。伴随着人工智能和机器人技术的进步，智能机器人将在工业生产、家庭服务、公共安全等领域发挥越来越大的作用，是“制造业皇冠顶端的明珠”。本课程将结合国防科技大学智能科学学院机器人研究中心的最新研究成果，以足球机器人、救援机器人、安保机器人等典型智能机器人为教学案例，讲授智能机器人系统的基本原理和关键技术，主要内容包括机器人的机构与平台、运动控制、智能感知、导航定位、协同控制、人机交互等。"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spu = SharedPreferencesUtil.getInstance(getApplicationContext());
        listView = (ListView) findViewById(R.id.lv_course);

        getData();
        ListAdapter listAdapter=new ListAdapter(this,R.layout.item_view,courseList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //点击每一行的点击事件
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long id) {
                Course cours=courseList.get(position);     //获取点击的那一行

                for(int i=0;i<8;i++){
                    if(cours.getCourseId().equals(dcourseIds[i])){
                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this, CourseDetailsActivity.class);
                        intent.putExtra("courseid",dcourseIds[i]);
                        intent.putExtra("teacher",dteachers[i]);
                        intent.putExtra("school",dschool[i]);
                        intent.putExtra("date",ddate[i]);
                        intent.putExtra("description",ddescription[i]);

                        startActivity(intent);
                    }
                }
            }
        });


    }

    private void getData(){
        int[] imageIds = { R.drawable.c, R.drawable.softwaretest,
                R.drawable.xd, R.drawable.digital,
                R.drawable.digitalmedia, R.drawable.logical,
                R.drawable.python, R.drawable.robot };

        String[] courseIds = {"C语言程序设计","软件测试与质量","线性代数",
                "数字图像处理","数字媒体技术概论","逻辑导论","Python编程基础","智能机器人系统"
        };

        String[] teachers = {"翁恺","武剑洁","靳全勤","贾永红",
                "严明","陈波","王恺","卢惠民"
        };

        String[] school = {"浙江大学","华中科技大学","同济大学",
                "武汉大学","中国传媒大学","北京大学","南开大学","国防科技大学"
        };

        for(int i=0;i<imageIds.length;i++){
            courseList.add(new Course(imageIds[i],courseIds[i],teachers[i],school[i]));
        }

    }

    public void onLogoutClick(View view) {
        spu.setLogin(false);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        finish();
    }

    public void onSearchClick(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}
