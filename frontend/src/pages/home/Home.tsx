import './Home.css'
import { useState, useEffect } from 'react'
import { Card, CardContent, Table, TableBody, TableCell, TableHead, TableRow, TableContainer } from '@mui/material'

interface Person {
    id: number;
    name: string;
}

const Home = () => {
    const [people, setPeople] = useState<Person[]>([])

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8080/logs')
                const data = await response.json()
                setPeople(data)
            } catch (error) {
                console.error('Error fetching data:', error)
            }
        }

        fetchData()
    }, [])

    return (
        <div className='home-container'>
            <Card className='card-container'>
                <CardContent>
                    <TableContainer>
                        <Table>
                            <TableHead>
                                <TableRow>
                                    <TableCell>ID</TableCell>
                                    <TableCell>Name</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {people.map((person) => (
                                    <TableRow key={person.id}>
                                        <TableCell>{person.id}</TableCell>
                                        <TableCell>{person.name}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </CardContent>
            </Card>
        </div>
    )
}

export default Home