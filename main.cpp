#include <iostream>
#include <iomanip>
#include <vector>
#include <random>
#include <algorithm>

using namespace std;

vector<int> same_data_generator(int cnt = 50){
    //生成测试用例,每次生成都是一样的数据序列
    vector<int> retvi;
    default_random_engine dr_engine;
    uniform_int_distribution<> ui_dtion(-100, 100);
    for( int i = 0; i < cnt; ++i )
        retvi.push_back( ui_dtion(dr_engine) );
    return retvi;
}

vector<int> random_data_generator(int cnt = 50){
    //生成测试用例,每次生成不同的数据序列
    vector<int> retvi;
    static default_random_engine dr_engine;
    static uniform_int_distribution<> ui_dtion(-100, 100);
    for( int i = 0; i < cnt; ++i )
        retvi.push_back( ui_dtion(dr_engine) );
    return retvi;
}

void display(const vector<int>::iterator &bgIter, decltype(bgIter) &edIter ){
    for( auto iter = bgIter; edIter != iter; ++iter ){
        cout << right << setw(5) <<*iter << "  ";
        if( !((iter - bgIter + 1 ) % 10) )
            cout << endl;
    }
}

template<class Iter>
inline bool compare(const Iter &left, const Iter &right ){
    return *left <= *right;
}

template<class Iter, class C = bool(const Iter&, const Iter&)>
void selection_sort( const Iter &bgIter, const Iter &edIter, C _compare = compare){
    //选择排序，不稳定，时间复杂度O(N^2)
    for( auto iter = bgIter; iter != edIter; ++iter ){
        auto miter = iter;
        for( auto jter = iter + 1; jter != edIter; ++jter )
            if( _compare(jter, miter) )
                miter = jter;
        if( iter != miter )
            swap(*iter, *miter);
    }
}


template<class Iter, class C = bool(const Iter&, const Iter&)>
void bubble_sort( const Iter &bgIter, const Iter &edIter, C _compare = compare){
    //冒泡排序，稳定排序，时间复杂度O(N^2)
    if( bgIter == edIter )//
        return;

    for( auto riIter = edIter - 1; riIter != bgIter; --riIter )
        for( auto iIter = bgIter+1; iIter != riIter +1; ++iIter )
            if( _compare(iIter, iIter-1 ) )
                swap( *iIter, *(iIter-1) );
    return;
}

template<class Iter, class C = bool(const Iter&, const Iter&)>
void quick_sort(const Iter &bgIter, const Iter &edIter, C _compare = compare){
    if( bgIter == edIter || (bgIter +1) == edIter )
        return;
    auto  iIter = bgIter +1;
    auto riIter = edIter -1;
    while( riIter - iIter >= 0 ){
        while(riIter - iIter >= 0 && _compare(iIter, bgIter)) ++iIter;
        while(riIter - iIter >= 0 && _compare(bgIter, riIter)) --riIter;
        if( riIter - iIter >= 0 )
            swap(*riIter, *iIter);
    }
    swap(*bgIter, *riIter);
    quick_sort(bgIter, riIter, _compare);
    quick_sort(iIter, edIter, _compare);
}

template<class Iter, class C = bool(const Iter&, const Iter&)>
void insert_sort(const Iter &bgIter, const Iter &edIter, C _compare = compare ){
    if( bgIter == edIter || (bgIter +1) == edIter )
        return;
    for(auto siter = bgIter+1; siter != edIter; ++siter ){
        auto usiter = siter;
        while( usiter != bgIter && _compare(usiter, usiter -1)){
            swap(*usiter, *(usiter-1));
            --usiter;
        }
    }
    return;
}

template<class Iter, class C = bool(const Iter&, const Iter&)>
void merge_sort(const Iter &bgIter, const Iter &edIter, C _compare = compare){
    if( bgIter == edIter || (bgIter + 1) == edIter )
        return ;
    auto midIter = bgIter + (edIter - bgIter)/2;
    merge_sort( bgIter, midIter, _compare);
    merge_sort( midIter, edIter, _compare);

    vector< typename remove_reference<decltype(*midIter)>::type > tempvi;

    auto liter = bgIter, riter = midIter;
    while( liter != midIter && riter != edIter ){
        if( _compare(liter, riter) )
            tempvi.push_back(*liter++);
        else tempvi.push_back(*riter++);
    }

    while(liter != midIter) tempvi.push_back( *liter++);
    while(riter != edIter ) tempvi.push_back( *riter++);
    /*
    for( auto iter = bgIter; iter != edIter; ++iter )
        *iter = *(tempvi.begin() + (iter - bgIter));
        */
    //move(liter, midIter, tempvi.end());
    //move(riter, edIter , tempvi.end());
    move(tempvi.begin(), tempvi.end(), bgIter);
    return;
}

template<class Iter, class C = bool(const Iter&, const Iter &)>
void shell_sort(const Iter &bgIter, const Iter &edIter,
                vector<int> shells, C _compare = compare){
    if( bgIter == edIter || (bgIter+1) == edIter )
        return;
    for( int shell : shells )
        for( int cnt = 0; cnt < shell; ++cnt)
            for( auto iter = bgIter +cnt +shell; iter < edIter; iter +=shell )
                for(auto riter = iter; riter != (bgIter +cnt) && _compare(riter, riter - shell); riter -= shell )
                    swap(*riter, *(riter-shell));
    return;
}

template<class Iter, class C = bool(const Iter&, const Iter&)>
void create_heap( const Iter& bgIter, const Iter &edIter,
                 int start, C _compare = compare ){

    int child = 2*start + 1;
    auto iter = bgIter + start;
    while( iter < edIter ){
        auto mciter = bgIter + child;
        if( (mciter + 1) < edIter && _compare(mciter, mciter+1) ){
           ++mciter;
           ++child;
        }//mciter指向较大的孩子元素
        if( mciter >= edIter ) // 没有孩子节点，已经是顶堆
            break;
        if( _compare(mciter, iter) )//父节点比孩子节点都大
            break;
        swap(*iter, *mciter);
        iter = mciter;
        child = 2*child + 1;
    }
    return ;
}

template<class Iter, class C = bool(const Iter&, const Iter&)>
void heap_sort(const Iter &bgIter, const Iter &edIter, C _compare = compare ){
    if( bgIter == edIter || (bgIter+1) == edIter )
        return;
    const int cnt = edIter - bgIter;
    for( int i = (cnt-2)/2; i >= 0; --i )
        create_heap(bgIter, edIter, i, _compare );

    for( int i = cnt-1; i > 0; --i ){
        swap( *bgIter, *(bgIter + i) );
        create_heap(bgIter, bgIter + i, 0, _compare );
    }
    return;
}

int main(){
    vector<int> vi = same_data_generator();

    heap_sort(vi.begin(), vi.end());

    display(vi.begin(), vi.end());
    return 0;
}
